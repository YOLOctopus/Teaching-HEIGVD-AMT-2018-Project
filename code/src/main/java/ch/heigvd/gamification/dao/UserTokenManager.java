package ch.heigvd.gamification.dao;

import ch.heigvd.gamification.model.User;
import ch.heigvd.gamification.model.UserToken;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class UserTokenManager extends GenericDAO<UserToken, Long> implements UserTokenManagerLocal {

    private static final Logger LOG = Logger.getLogger(GenericDAO.class.getName());

    public UserToken findByToken(String token) {
        UserToken userToken = null;
        try {
            userToken = (UserToken) em.createNamedQuery("UserToken.findByToken").setParameter("token", token).getSingleResult();
        } catch (NoResultException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return userToken;
    }

    public UserToken findByUser(User user) {
        UserToken userToken = null;
        try {
            userToken = (UserToken) em.createNamedQuery("UserToken.findByUser").setParameter("user", user).getSingleResult();
        } catch (NoResultException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return userToken;
    }
}
