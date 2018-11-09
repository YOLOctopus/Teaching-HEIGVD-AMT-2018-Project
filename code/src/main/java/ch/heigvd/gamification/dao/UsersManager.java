package ch.heigvd.gamification.dao;

import ch.heigvd.gamification.model.User;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.sql.DataSource;
import java.util.LinkedList;
import java.util.List;

@Stateless
public class UsersManager extends GenericDAO<User, Long> implements UsersManagerLocal {
    @Resource(lookup = "jdbc/myressource")
    private DataSource dataSource;

    @Override
    public User findByEmail(String mail) {
        User user = null;
        try {
            user = (User) em.createNamedQuery("User.findByEmail").setParameter("email", mail).getSingleResult();
        } catch (NoResultException e) {

        }
        return user;
    }

    @Override
    public List<User> findByQuery(String query) {
        List<User> users = new LinkedList<>();
        try {
            users = em.createNamedQuery("User.findByQuery").setParameter("query", query).getResultList();
        } catch (NoResultException ex) {
            //TODO: LOG
        }
        return users;
    }
}
