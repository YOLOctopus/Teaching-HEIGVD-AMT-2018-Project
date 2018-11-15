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
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ApplicationServlet")
public class ApplicationServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(ApplicationServlet.class.getName());

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
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }
        application.setName(name);
        application.setDescription(description);
        try {
            applicationsManager.update(application);
        } catch (BusinessDomainEntityNotFoundException e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
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
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }
        request.setAttribute("application", application);
        request.getRequestDispatcher("/WEB-INF/pages/application.jsp").forward(request, response);
    }
}
