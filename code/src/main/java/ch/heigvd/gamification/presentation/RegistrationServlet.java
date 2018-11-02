package ch.heigvd.gamification.presentation;

import ch.heigvd.gamification.business.RegisterConfirmation;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    RegisterConfirmation registerConfirmation;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        registerConfirmation = new RegisterConfirmation();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");

        ArrayList<String> errors = new ArrayList<>();

        if (!registerConfirmation.validEmail(email)) {
            errors.add("Invalid email");
        }
        if (!registerConfirmation.validPassword(pwd)) {
            errors.add("invalid password");
        }

        // test fields
        if () {
            // Call DAO manager to insert user in DB

            // Define session / set user as connected

            request.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(request, response);
        } else {
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
    }
}
