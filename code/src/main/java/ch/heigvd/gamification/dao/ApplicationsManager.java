/**
 * @document ApplicationsManager
 * @date 28.10.2018
 * @author Samuel Mayor, Alexandra Korukova, Pierre-Samuel Rochat and Arnold von Bauer Gauss
 * @Goal Acts as a link between the DB table application and the web application
 */

package ch.heigvd.gamification.dao;

import ch.heigvd.gamification.model.Application;
import ch.heigvd.gamification.model.User;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class ApplicationsManager extends GenericDAO<Application, Long> implements ApplicationsManagerLocal {

    private static final Logger LOG = Logger.getLogger(ApplicationsManager.class.getName());

    @Override
    public List<Application> findByUser(User user) {
        List<Application> applications = new LinkedList<>();
        applications = em.createNamedQuery("Application.findByUser")
                .setParameter("user", user.getId())
                .getResultList();
        return  applications;
    }

    @Override
    public List<Application> findByUserByPage(User user, int pageSize, int pageIndex) {
        List<Application> applications = new LinkedList<>();
        applications = em.createNamedQuery("Application.findByUser")
                .setParameter("user", user.getId())
                .setMaxResults(pageSize)
                .setFirstResult(pageIndex*pageSize)
                .getResultList();
        return applications;
    }

    @Override
    public List<Application> findByQuery(User user, String query) {
        List<Application> applications = new LinkedList<>();
        try {
            applications = em.createNamedQuery("Application.findByQuery")
                    .setParameter("user", user.getId())
                    .setParameter("query", query)
                    .getResultList();
        } catch (NoResultException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return applications;
    }
}
