package ch.heigvd.gamification.presentation;

import ch.heigvd.gamification.business.LoginConfirmation;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    LoginConfirmation loginConfirmation;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        loginConfirmation = new LoginConfirmation();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");

        if (loginConfirmation.confirm(email, pwd)) {
            request.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
    }
}
