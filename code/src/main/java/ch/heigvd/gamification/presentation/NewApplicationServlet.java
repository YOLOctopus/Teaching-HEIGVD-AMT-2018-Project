/**
 * @document NewApplicationServlet
 * @date 28.10.2018
 * @author Samuel Mayor, Alexandra Korukova, Pierre-Samuel Rochat and Arnold von Bauer Gauss
 * @Goal Process requests for the creation of a new application
 */

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
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "NewApplicationServlet")
public class NewApplicationServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(NewApplicationServlet.class.getName());

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
            User user = null;
            try {
                user = usersManager.findById(idUser);
            } catch (BusinessDomainEntityNotFoundException e) {
                LOG.log(Level.SEVERE, e.getMessage(), e);
            }
            Application application = new Application(name, description, apiKey, apiSecret, user);
            applicationsManager.create(application);
            request.setAttribute("application", application);
            request.getRequestDispatcher("/WEB-INF/pages/application.jsp").forward(request, response);
        } else {
            request.setAttribute("id", idUser);
            request.getRequestDispatcher("/WEB-INF/pages/newapplication.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
