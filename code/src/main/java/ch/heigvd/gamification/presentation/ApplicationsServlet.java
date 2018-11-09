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

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final int MAX_PAGINATION_PAGE = 10;
        Long idUser = Long.parseLong(request.getParameter("user"));
        User user = null;
        try {
            user = usersManager.findById(idUser);
        } catch (BusinessDomainEntityNotFoundException e) {
            e.printStackTrace();
        }
        int page = 0;
        int pageSize = 5;
        if (request.getParameterMap().containsKey("page")) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        if (request.getParameterMap().containsKey("pagesize")) {
            pageSize = Integer.parseInt(request.getParameter("pagesize"));
        }

        Long totalSize = applicationsManager.count();
        int minPage = Math.max(0, page - MAX_PAGINATION_PAGE/2);
        int maxPage = (int)Math.min(page + MAX_PAGINATION_PAGE/2-1, totalSize/pageSize-1);

        List<Application> applications = applicationsManager.findByUserByPage(user, pageSize, page);
        request.setAttribute("applications", applications);
        request.setAttribute("idUser", idUser);
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("page", page);
        request.setAttribute("totalSize", totalSize);
        request.setAttribute("minPage", minPage);
        request.setAttribute("maxPage", maxPage);
        request.getRequestDispatcher("/WEB-INF/pages/applications.jsp").forward(request, response);
    }
}
