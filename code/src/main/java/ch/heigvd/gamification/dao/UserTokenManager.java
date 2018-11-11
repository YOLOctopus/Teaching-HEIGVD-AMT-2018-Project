package ch.heigvd.gamification.dao;

import ch.heigvd.gamification.model.User;
import ch.heigvd.gamification.model.UserToken;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;

@Stateless
public class UserTokenManager extends GenericDAO<UserToken, Long> implements UserTokenManagerLocal {
    public UserToken findByToken(String token) {
        UserToken userToken = null;
        try {
            userToken = (UserToken) em.createNamedQuery("UserToken.findByToken").setParameter("token", token).getSingleResult();
        } catch (NoResultException ex) {
            //TODO: log
        }
        return userToken;
    }

    public UserToken findByUser(User user) {
        UserToken userToken = null;
        try {
            userToken = (UserToken) em.createNamedQuery("UserToken.findByUser").setParameter("user", user).getSingleResult();
        } catch (NoResultException ex) {
            //TODO: log
        }
        return userToken;
    }
}
