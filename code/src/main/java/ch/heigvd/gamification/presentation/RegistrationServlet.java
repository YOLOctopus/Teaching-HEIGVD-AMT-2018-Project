package ch.heigvd.gamification.presentation;

import ch.heigvd.gamification.business.EmailSender;
import ch.heigvd.gamification.business.RegisterConfirmation;
import ch.heigvd.gamification.dao.BusinessDomainEntityNotFoundException;
import ch.heigvd.gamification.dao.UserTokenManagerLocal;
import ch.heigvd.gamification.dao.UsersManagerLocal;
import ch.heigvd.gamification.model.User;
import ch.heigvd.gamification.model.UserToken;

import javax.ejb.EJB;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    @EJB
    UsersManagerLocal usersManager;

    @EJB
    RegisterConfirmation registerConfirmation;

    @EJB
    UserTokenManagerLocal userTokenManager;

    @EJB
    EmailSender emailSender;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");

        ArrayList<String> errors = new ArrayList<>();

        if (firstName.length() == 0)
            errors.add("Please input your first name");
        if (lastName.length() == 0)
            errors.add("Please input your last name");
        try {
            if (!registerConfirmation.validEmail(email))
                errors.add("Invalid email");
        } catch (BusinessDomainEntityNotFoundException e) {
            //TODO: log
        }
        if (!registerConfirmation.validPassword(pwd))
            errors.add("invalid password");

        // test fields
        if (errors.isEmpty()) {
            // Call DAO manager to insert user in DB
            User user = usersManager.createAndReturnManagedEntity(new User(firstName, lastName, email, pwd, false, false, false));
            UserToken userToken = new UserToken(user);
            userTokenManager.create(userToken);
            try {
                emailSender.sendEmail(
                        "Account creation confirmation",
                        user.getEmail(),
                        user.getFirstName() + " " + user.getLastName(), "Please follow this link to activate your account : http://localhost:8080/gamification/pages/accountactivation?token=" + userToken.getToken());
            } catch (MessagingException e) {
                //TODO: log
            }
            request.getRequestDispatcher("/WEB-INF/pages/registerconfirmation.jsp").forward(request, response);
        } else {
            request.setAttribute("errors", errors);
            request.setAttribute("firstName", firstName);
            request.setAttribute("lastName", lastName);
            request.setAttribute("email", email);
            request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
    }
}
