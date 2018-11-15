/**
 * @document LoginConfirmation
 * @date 28.10.2018
 * @author Samuel Mayor, Alexandra Korukova, Pierre-Samuel Rochat and Arnold von Bauer Gauss
 * @Goal EJB that checks that login fields are correct and check the DB if email and password match
 */

package ch.heigvd.gamification.business;

import ch.heigvd.gamification.dao.BusinessDomainEntityNotFoundException;
import ch.heigvd.gamification.dao.UsersManagerLocal;
import ch.heigvd.gamification.model.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class LoginConfirmation {

    @EJB
    UsersManagerLocal usersManager;

    public LoginConfirmation() {
    }

    /**
     * Confirm if email and password are a match in the DB and fied
     * @param email Email to confirm
     * @param password Password to confirm
     * @return Boolean whether password and email match
     * @throws BusinessDomainEntityNotFoundException
     */
    public Boolean confirm(String email, String password) throws BusinessDomainEntityNotFoundException {
        return checkPwd(email, password);
    }

    /**
     * Check if given email is linked to an admin account
     * @param email Email to lookup the user
     * @return Boolean whether given email is linked to an admin account
     */
    public Boolean isAdmin(String email) {
        User user = usersManager.findByEmail(email);
        return user.isAdmin();
    }

    /**
     * Checks password and email to see if user exists in the DB
     * @param email email to check
     * @param pwd password to check
     * @return Boolean whether the password matches or not
     * @throws BusinessDomainEntityNotFoundException
     */
    private boolean checkPwd(String email, String pwd) throws BusinessDomainEntityNotFoundException {
        User user = usersManager.findByEmail(email);
        return user != null && pwd.equals(user.getPassword());
    }
}
