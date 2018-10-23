package ch.heigvd.gamification.business;

import ch.heigvd.gamification.model.User;

public class LoginConfirmation {

    User[] users;

    public LoginConfirmation() {
        users = new User[10];
        users[0] = new User("Sam", "May", "sam@gmail.com", "1234");
        users[1] = new User("admin", "admin", "admin@gmail.com", "1234");
    }

    public boolean confirm(String email, String password) {
        return  checkEmail(email) && checkPwd(email, password);
    }


    private boolean checkPwd(String email, String pwd) {
        User user = getUserByEmail(email);
        return (pwd.equals(user.getPassword()));
    }

    private boolean checkEmail(String email) {
        return email.contains("@") && getUserByEmail(email) != null;
    }

    private User getUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().toLowerCase().equals(email.toLowerCase()))
                return user;
        }
        return null;
    }
}
