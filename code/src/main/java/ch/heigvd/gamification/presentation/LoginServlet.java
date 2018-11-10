package ch.heigvd.gamification.presentation;

import ch.heigvd.gamification.business.LoginConfirmation;
import ch.heigvd.gamification.dao.BusinessDomainEntityNotFoundException;
import ch.heigvd.gamification.dao.UsersManagerLocal;

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
                HttpSession session = request.getSession();
                session.setAttribute("user", email);
                session.setAttribute("id", usersManager.findByEmail(email).getId());
                session.setAttribute("admin", loginConfirmation.isAdmin(email));
                session.setMaxInactiveInterval(30*60);
                String encodedURL = response.encodeRedirectURL("home");
                response.sendRedirect(encodedURL);
            } else {
                request.setAttribute("error", "Invalid login or password");
                request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
            }
        } catch (BusinessDomainEntityNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
    }
}
