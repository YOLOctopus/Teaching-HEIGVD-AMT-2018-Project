/**
 * @document ApplicationsManagerLocal
 * @date 28.10.2018
 * @author Samuel Mayor, Alexandra Korukova, Pierre-Samuel Rochat and Arnold von Bauer Gauss
 */

package ch.heigvd.gamification.dao;

import ch.heigvd.gamification.model.Application;
import ch.heigvd.gamification.model.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ApplicationsManagerLocal extends IGenericDAO<Application, Long> {
    List<Application> findByUser(User user);
    List<Application> findByUserByPage(User user, int pageSize, int pageIndex);
    List<Application> findByQuery(User user, String query);
}
