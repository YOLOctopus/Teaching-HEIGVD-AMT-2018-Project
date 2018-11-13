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

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
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
                    request.setAttribute("error", "Your account has been suspended. Please contact an administrator if you don't know the reason behind it.");
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
            //TODO: log

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
    }
}
