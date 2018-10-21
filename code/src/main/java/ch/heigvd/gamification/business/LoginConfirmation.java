package ch.heigvd.gamification.business;


import ch.heigvd.gamification.model.User;

public class LoginConfirmation {

    User[] users;

    public LoginConfirmation() {
        users = new User[10];
        users[0] = new User("Sam", "123", "sam@gmail.com");
        users[1] = new User("admin", "123", "admin@gmail.com");
    }

    public boolean confirm(String login, String password, String email) {
        return checkLogin(login) && checkPwd(password) && checkEmail(email);
    }

    private boolean checkLogin(String login) {
        return getUserByName(login) != null;
    }

    private boolean checkPwd(String pwd) {
        return (!pwd.equals("") && !pwd.contains(" "));
    }

    private boolean checkEmail(String email) {
        return email.contains("@") && getUserByEmail(email) == null;
    }

    private User getUserByName(String name) {
        for (User user : users) {
            if (user.getName().toLowerCase().equals(name.toLowerCase()))
                return user;
        }
        return null;
    }

    private User getUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().toLowerCase().equals(email.toLowerCase()))
                return user;
        }
        return null;
    }
}
