package ch.heigvd.gamification.presentation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomeServlet")
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pageTitle", "Gamification API");
        String success = request.getParameter("success");
        if (success != null && success.equals("true")) {
            response.getWriter().println("You are logged in");
        }
        request.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(request, response);
    }
}
