package ch.heigvd.gamification.dao;

import ch.heigvd.gamification.model.User;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.sql.DataSource;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class UsersManager extends GenericDAO<User, Long> implements UsersManagerLocal {

    private static final Logger LOG = Logger.getLogger(UsersManager.class.getName());

    @Resource(lookup = "jdbc/myressource")
    private DataSource dataSource;

    @Override
    public User findByEmail(String mail) {
        User user = null;
        try {
            user = (User) em.createNamedQuery("User.findByEmail").setParameter("email", mail).getSingleResult();
        } catch (NoResultException e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }
        return user;
    }

    @Override
    public List<User> findByQuery(String query) {
        List<User> users = new LinkedList<>();
        try {
            users = em.createNamedQuery("User.findByQuery").setParameter("query", query).getResultList();
        } catch (NoResultException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return users;
    }
}
