package ch.heigvd.gamification.dao;

import ch.heigvd.gamification.model.User;
import ch.heigvd.gamification.model.UserToken;

import javax.ejb.Local;

@Local
public interface UserTokenManagerLocal extends IGenericDAO<UserToken, Long>  {
    UserToken findByToken(String token);
    UserToken findByUser(User user);
}
