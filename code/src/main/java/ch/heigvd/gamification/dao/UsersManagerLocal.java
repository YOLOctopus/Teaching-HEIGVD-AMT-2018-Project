package ch.heigvd.gamification.dao;

import ch.heigvd.gamification.model.User;

import javax.ejb.Local;

@Local
public interface UsersManagerLocal extends IGenericDAO<User, Long> {
    User findByEmail(String mail);
}
