package ch.heigvd.gamification.presentation;

import ch.heigvd.gamification.business.RegisterConfirmation;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegistrationConfirmationServlet")
public class RegistrationConfirmationServlet extends HttpServlet {
    private RegisterConfirmation registerConfirmation;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        registerConfirmation = new RegisterConfirmation();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("pwd");
        PrintWriter writer = response.getWriter();

        if (registerConfirmation.validEmail(email) && registerConfirmation.validPassword(password)) {
            writer.println(
                    "<html>" +
                        "<h3>Registration successful</h3>" +
                        "<p>Name : " + firstName + " " + lastName + "</p>" +
                        "<p>Email: " + email + "</p>" +
                        "<p><a href='./home'>Back</a></p>" +
                    "</html>");
        } else {
            writer.println(
                    "<html>" +
                        "<h3>Email or password invalid</h3>" +
                        "<p><a href='./pages/register'>Back</a></p>" +
                    "</html>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
