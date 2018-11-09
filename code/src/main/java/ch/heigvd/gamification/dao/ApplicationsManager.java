package ch.heigvd.gamification.dao;

import ch.heigvd.gamification.model.Application;
import ch.heigvd.gamification.model.User;

import javax.ejb.Stateless;
import java.util.LinkedList;
import java.util.List;

@Stateless
public class ApplicationsManager extends GenericDAO<Application, Long> implements ApplicationsManagerLocal {
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
}
