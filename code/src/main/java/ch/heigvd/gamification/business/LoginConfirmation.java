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

    public Boolean confirm(String email, String password) throws BusinessDomainEntityNotFoundException {
        return checkEmail(email) && checkPwd(email, password) && usersManager.findByEmail(email).isActive();
    }

    public Boolean isAdmin(String email) {
        User user = usersManager.findByEmail(email);
        return user.isAdmin();
    }

    private boolean checkPwd(String email, String pwd) throws BusinessDomainEntityNotFoundException {
        User user = usersManager.findByEmail(email);
        return user != null && pwd.equals(user.getPassword());
    }

    private boolean checkEmail(String email) throws BusinessDomainEntityNotFoundException {
        return email.contains("@") && usersManager.findByEmail(email) != null;
    }
}
