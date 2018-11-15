/**
 * @document ApplicationsServlet
 * @date 28.10.2018
 * @author Samuel Mayor, Alexandra Korukova, Pierre-Samuel Rochat and Arnold von Bauer Gauss
 * @Goal Process requests for applications list.
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
import java.util.List;

@WebServlet(name = "ApplicationsServlet")
public class ApplicationsServlet extends HttpServlet {
    @EJB
    ApplicationsManagerLocal applicationsManager;

    @EJB
    UsersManagerLocal usersManager;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameterMap().containsKey("delete")) {
            User user = null;
            Application appToDelete = null;
            try {
                appToDelete = applicationsManager.findById(Long.parseLong(request.getParameter("delete")));
                user = appToDelete.getUser();
                applicationsManager.delete(appToDelete);
            } catch (BusinessDomainEntityNotFoundException e) {
                //TODO: log
            }
            response.sendRedirect("./applications?user=" + user.getId());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idUser = Long.parseLong(request.getParameter("user"));
        User user = null;
        try {
            user = usersManager.findById(idUser);
        } catch (BusinessDomainEntityNotFoundException e) {
            //TODO: log
        }
        List<Application> applications;

        if(request.getParameterMap().containsKey("query")) {
            applications = applicationsManager.findByQuery(user, "%" + request.getParameter("query") + "%");
        } else {
            final int MAX_PAGINATION_PAGE = 10;
            int page = 0;
            int pageSize = 5;
            if (request.getParameterMap().containsKey("page")) {
                page = Integer.parseInt(request.getParameter("page"));
            }
            if (request.getParameterMap().containsKey("pagesize")) {
                pageSize = Integer.parseInt(request.getParameter("pagesize"));
            }

            Long totalSize = applicationsManager.count();
            int minPage = Math.max(0, page - MAX_PAGINATION_PAGE / 2);
            int maxPage = (int) Math.min(page + MAX_PAGINATION_PAGE / 2 - 1, totalSize / pageSize - 1);
            applications = applicationsManager.findByUserByPage(user, pageSize, page);
            request.setAttribute("pageSize", pageSize);
            request.setAttribute("page", page);
            request.setAttribute("totalSize", totalSize);
            request.setAttribute("minPage", minPage);
            request.setAttribute("maxPage", maxPage);
        }
        request.setAttribute("idUser", idUser);
        request.setAttribute("applications", applications);
        request.getRequestDispatcher("/WEB-INF/pages/applications.jsp").forward(request, response);
    }
}
