package ch.heigvd.gamification.dao;

import ch.heigvd.gamification.model.User;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.sql.DataSource;

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


}
