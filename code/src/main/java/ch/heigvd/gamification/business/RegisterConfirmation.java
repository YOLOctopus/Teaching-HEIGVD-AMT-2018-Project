package ch.heigvd.gamification.business;

import ch.heigvd.gamification.dao.BusinessDomainEntityNotFoundException;
import ch.heigvd.gamification.dao.UsersManagerLocal;
import ch.heigvd.gamification.model.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class RegisterConfirmation {
    @EJB
    UsersManagerLocal usersManager;

    /**
     * checks database if email exists and if email is in right format
     * @param email
     * @return wether email is valid or not
     */
    public boolean validEmail(String email) throws BusinessDomainEntityNotFoundException {
        User user = usersManager.findByEmail(email);
        return user == null && email.length() > 4 && email.substring(1, email.length()-1).contains("@");
    }

    /**
     * checks database if password is in right format
     * @param password
     * @return wether password is valid or not
     */
    public boolean validPassword(String password) {
        return password.length() >= 7;
    }

}
