package ch.heigvd.gamification.presentation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegistrationConfirmationServlet")
public class RegistrationConfirmationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String appName = request.getParameter("appname");
        String username = request.getParameter("usrname");
        String password = request.getParameter("pwd");
        String email = request.getParameter("email");

        PrintWriter writer = response.getWriter();

        writer.println(
                "<html>" +
                    "<p>" + appName + "</p>" +
                    "<p>" + username + "</p>" +
                    "<p>" + password + "</p>" +
                    "<p>" + email + "</p>" +
                "</html>");
    }
}
