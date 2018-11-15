/**
 * @document LoginServlet
 * @date 28.10.2018
 * @author Samuel Mayor, Alexandra Korukova, Pierre-Samuel Rochat and Arnold von Bauer Gauss
 * @Goal Process requests for user login
 */

package ch.heigvd.gamification.presentation;

import ch.heigvd.gamification.business.LoginConfirmation;
import ch.heigvd.gamification.dao.BusinessDomainEntityNotFoundException;
import ch.heigvd.gamification.dao.UsersManagerLocal;
import ch.heigvd.gamification.model.User;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(LoginServlet.class.getName());

    @EJB
    LoginConfirmation loginConfirmation;

    @EJB
    UsersManagerLocal usersManager;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");

        try {
            if (loginConfirmation.confirm(email, pwd)) {
                User user = usersManager.findByEmail(email);
                if (user.isMustResetPassword()) {
                    request.setAttribute("userId", user.getId());
                    request.setAttribute("error", "Please reset your password before you can log in.");
                    request.getRequestDispatcher("/WEB-INF/pages/passwordreset.jsp").forward(request, response);
                } else if (!user.isActive()) {
                    request.setAttribute("error", "Your account is inactive. Please check your mails or contact an administrator.");
                    request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
                } else {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", email);
                    session.setAttribute("id", user.getId());
                    session.setAttribute("admin", loginConfirmation.isAdmin(email));
                    session.setMaxInactiveInterval(30 * 60);
                    String encodedURL = response.encodeRedirectURL("home");
                    response.sendRedirect(encodedURL);
                }
            } else {
                request.setAttribute("error", "Invalid login or password");
                request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
            }
        } catch (BusinessDomainEntityNotFoundException e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
    }
}
