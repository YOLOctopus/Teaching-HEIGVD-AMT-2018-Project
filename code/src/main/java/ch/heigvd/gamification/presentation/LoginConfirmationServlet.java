package ch.heigvd.gamification.presentation;

import ch.heigvd.gamification.business.LoginConfirmation;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginConfirmationServlet")
public class LoginConfirmationServlet extends HttpServlet {
    private LoginConfirmation loginConfirmation;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        loginConfirmation = new LoginConfirmation();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("pwd");

        if (loginConfirmation.confirm(email, password)) {
            request.setAttribute("success", "true");
            request.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(request, response);
        } else {
            request.setAttribute("success", "false");
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
