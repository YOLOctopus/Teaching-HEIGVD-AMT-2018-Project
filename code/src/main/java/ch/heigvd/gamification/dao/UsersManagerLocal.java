/**
 * @document UsersManagerLocal
 * @date 28.10.2018
 * @author Samuel Mayor, Alexandra Korukova, Pierre-Samuel Rochat and Arnold von Bauer Gauss
 */

package ch.heigvd.gamification.dao;

import ch.heigvd.gamification.model.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UsersManagerLocal extends IGenericDAO<User, Long> {
    User findByEmail(String mail);
    List<User> findByQuery(String query);
}
