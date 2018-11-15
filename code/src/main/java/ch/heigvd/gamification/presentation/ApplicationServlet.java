/**
 * @document ApplicationServlet
 * @date 28.10.2018
 * @author Samuel Mayor, Alexandra Korukova, Pierre-Samuel Rochat and Arnold von Bauer Gauss
 * @Goal Process requests to display a single application and its properties
 */

package ch.heigvd.gamification.presentation;

import ch.heigvd.gamification.dao.ApplicationsManagerLocal;
import ch.heigvd.gamification.dao.BusinessDomainEntityNotFoundException;
import ch.heigvd.gamification.model.Application;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ApplicationServlet")
public class ApplicationServlet extends HttpServlet {
    @EJB
    ApplicationsManagerLocal applicationsManager;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        Application application = null;

        try {
            application = applicationsManager.findById(id);
        } catch (BusinessDomainEntityNotFoundException e) {
            //TODO: log
        }
        application.setName(name);
        application.setDescription(description);
        try {
            applicationsManager.update(application);
        } catch (BusinessDomainEntityNotFoundException e) {
            //TODO: log
        }
        request.setAttribute("success", true);
        request.setAttribute("id", application.getId());
        request.setAttribute("application", application);
        request.getRequestDispatcher("/WEB-INF/pages/application.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idApplication = Long.parseLong(request.getParameter("id"));
        Application application = null;
        try {
            application = applicationsManager.findById(idApplication);
        } catch (BusinessDomainEntityNotFoundException e) {
            //TODO: log
        }
        request.setAttribute("application", application);
        request.getRequestDispatcher("/WEB-INF/pages/application.jsp").forward(request, response);
    }
}
