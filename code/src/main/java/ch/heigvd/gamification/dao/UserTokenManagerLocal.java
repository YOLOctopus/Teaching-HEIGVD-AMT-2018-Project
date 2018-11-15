/**
 * @document UserTokenManagerLocal
 * @date 28.10.2018
 * @author Samuel Mayor, Alexandra Korukova, Pierre-Samuel Rochat and Arnold von Bauer Gauss
 */

package ch.heigvd.gamification.dao;

import ch.heigvd.gamification.model.User;
import ch.heigvd.gamification.model.UserToken;

import javax.ejb.Local;

@Local
public interface UserTokenManagerLocal extends IGenericDAO<UserToken, Long>  {
    UserToken findByToken(String token);
    UserToken findByUser(User user);
}
