package ch.heigvd.gamification.dao;

import ch.heigvd.gamification.model.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UsersManagerLocal {
    List<User> findAllUsers();
    User findByEmail(String mail);
}
