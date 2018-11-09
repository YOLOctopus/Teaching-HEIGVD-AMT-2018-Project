package ch.heigvd.gamification.presentation;

import ch.heigvd.gamification.dao.UsersManagerLocal;
import ch.heigvd.gamification.model.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UsersServlet")
public class UsersServlet extends HttpServlet {
    @EJB
    UsersManagerLocal usersManager;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users;
        if (request.getParameterMap().containsKey("query")) {
            users = usersManager.findByQuery("%" + request.getParameter("query") + "%");
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

            Long totalSize = usersManager.count();
            int minPage = Math.max(0, page - MAX_PAGINATION_PAGE / 2);
            int maxPage = (int) Math.min(page + MAX_PAGINATION_PAGE / 2 - 1, totalSize / pageSize - 1);

            users = usersManager.findAllByPage(pageSize, page);
            request.setAttribute("pageSize", pageSize);
            request.setAttribute("page", page);
            request.setAttribute("totalSize", totalSize);
            request.setAttribute("minPage", minPage);
            request.setAttribute("maxPage", maxPage);
        }
        request.setAttribute("users", users);
        request.getRequestDispatcher("/WEB-INF/pages/users.jsp").forward(request, response);
    }
}
