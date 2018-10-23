package ch.heigvd.gamification.presentation;

import ch.heigvd.gamification.business.LoginConfirmation;
import ch.heigvd.gamification.business.RegisterConfirmation;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
            response.sendRedirect("/pages/home?success=true");
        } else {
            response.sendRedirect("/pages/login?success=false");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
