package ch.heigvd.gamification.business;

public class RegisterConfirmation {

    /**
     * checks database if email exists and if email is in right format
     * @param email
     * @return wether email is valid or not
     */
    public boolean validEmail(String email) {
        // TODO: check database
        return email.length() > 4 && email.substring(1, email.length()-1).contains("@");
    }

    /**
     * checks database if password is in right format
     * @param password
     * @return wether password is valid or not
     */
    public boolean validPassword(String password) {
        return true;
    }
}
