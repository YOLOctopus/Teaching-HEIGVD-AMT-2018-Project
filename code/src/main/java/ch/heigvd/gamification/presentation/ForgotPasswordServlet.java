/**
 * @document ForgotPasswordServlet
 * @date 28.10.2018
 * @author Samuel Mayor, Alexandra Korukova, Pierre-Samuel Rochat and Arnold von Bauer Gauss
 * @Goal Process requests for the forgot password page. Sends an email to the provided address
 */

package ch.heigvd.gamification.presentation;

import ch.heigvd.gamification.business.EmailSender;
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
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(ForgotPasswordServlet.class.getName());

    @EJB
    UsersManagerLocal usersManager;

    @EJB
    UserTokenManagerLocal userTokenManager;

    @EJB
    EmailSender emailSender;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        User user = usersManager.findByEmail(email);
        UserToken userToken = userTokenManager.findByUser(user);
        try {
            emailSender.sendEmail(
                    "Password reset request",
                    email,
                    user.getFirstName() + " " + user.getLastName(), "Please follow this link to reset your password : http://localhost:8080/gamification/pages/resetpassword?token=" + userToken.getToken());
        } catch (MessagingException e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }
        request.setAttribute("email", email);
        request.getRequestDispatcher("/WEB-INF/pages/forgotpassword.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/forgotpassword.jsp").forward(request, response);
    }
}
