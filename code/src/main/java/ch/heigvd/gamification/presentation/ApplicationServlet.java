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

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idApplication = Long.parseLong(request.getParameter("id"));
        Application application = null;
        try {
            application = applicationsManager.findById(idApplication);
        } catch (BusinessDomainEntityNotFoundException e) {
            e.printStackTrace();
        }
        request.setAttribute("application", application);
        request.getRequestDispatcher("/WEB-INF/pages/application.jsp").forward(request, response);
    }
}
