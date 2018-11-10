package ch.heigvd.gamification.presentation;

import ch.heigvd.gamification.dao.ApplicationsManagerLocal;
import ch.heigvd.gamification.dao.BusinessDomainEntityNotFoundException;
import ch.heigvd.gamification.dao.UsersManagerLocal;
import ch.heigvd.gamification.model.Application;
import ch.heigvd.gamification.model.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "NewApplicationServlet")
public class NewApplicationServlet extends HttpServlet {
    @EJB
    UsersManagerLocal usersManager;

    @EJB
    ApplicationsManagerLocal applicationsManager;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idUser = Long.parseLong(request.getParameter("id"));
        if (request.getParameterMap().containsKey("name")) {
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String apiKey = UUID.randomUUID().toString();
            String apiSecret = UUID.randomUUID().toString();
            Application application = new Application(name, description, apiKey, apiSecret);
            //TODO: Continue
        }

        request.getRequestDispatcher("/WEB-INF/pages/newapplication.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
