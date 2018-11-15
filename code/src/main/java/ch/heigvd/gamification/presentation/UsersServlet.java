/**
 * @document UsersServlet
 * @date 28.10.2018
 * @author Samuel Mayor, Alexandra Korukova, Pierre-Samuel Rochat and Arnold von Bauer Gauss
 * @Goal Process requests for users list.
 */

package ch.heigvd.gamification.presentation;

import ch.heigvd.gamification.business.EmailSender;
import ch.heigvd.gamification.dao.ApplicationsManagerLocal;
import ch.heigvd.gamification.dao.BusinessDomainEntityNotFoundException;
import ch.heigvd.gamification.dao.UsersManagerLocal;
import ch.heigvd.gamification.model.Application;
import ch.heigvd.gamification.model.User;

import javax.ejb.EJB;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "UsersServlet")
public class UsersServlet extends HttpServlet {
    @EJB
    UsersManagerLocal usersManager;

    @EJB
    ApplicationsManagerLocal applicationsManager;

    @EJB
    EmailSender emailSender;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameterMap().containsKey("reset") || request.getParameterMap().containsKey("setactive") || request.getParameterMap().containsKey("delete")) {
            String[] selectedUsers = request.getParameterValues("users");
            if (selectedUsers != null) {
                for (String userId : selectedUsers) {
                    Long id = Long.parseLong(userId);
                    User user = null;
                    try {
                        user = usersManager.findById(id);
                    } catch (BusinessDomainEntityNotFoundException e) {
                        //TODO: log
                        request.setAttribute("info", "Unable to find a user");
                    }
                    if (request.getParameterMap().containsKey("reset")) {
                        String newPassword = UUID.randomUUID().toString();
                        user.setPassword(newPassword);
                        user.setMustResetPassword(true);
                        try {
                            usersManager.update(user);
                            request.setAttribute("info", "Operation successfully executed");
                        } catch (BusinessDomainEntityNotFoundException e) {
                            //TODO: log
                            request.setAttribute("info", "There was a problem while during the update");
                        }
                        try {
                            emailSender.sendEmail("Your password has been reset",
                                    user.getEmail(),
                                    user.getFirstName() + " " + user.getLastName(),
                                    "Your password has been reset by an administrator. Use this password to log in. You will then be asked to change it. New password : " + newPassword);
                            request.setAttribute("info", "Operation successfully executed");
                        } catch (MessagingException e) {
                            //TODO: log
                            request.setAttribute("info", "Mail couldn't be sent");
                        }
                    } else if (request.getParameterMap().containsKey("setactive")) {
                        user.setActive(!user.isActive());
                        try {
                            usersManager.update(user);
                            request.setAttribute("info", "Operation successfully executed");
                        } catch (BusinessDomainEntityNotFoundException e) {
                            //TODO: log
                            request.setAttribute("info", "There was a problem while during the update");
                        }
                    } else if (request.getParameterMap().containsKey("delete")) {
                        for (Application application : user.getApplications()) {
                            try {
                                applicationsManager.delete(application);
                            } catch (BusinessDomainEntityNotFoundException e) {
                                //TODO: log
                                request.setAttribute("info", "There was a problem while deleting an application");
                            }
                        }

                        try {
                            usersManager.delete(user);
                            request.setAttribute("info", "Operation successfully executed");
                        } catch (BusinessDomainEntityNotFoundException e) {
                            //TODO: log
                            request.setAttribute("info", "There was a problem while deleting a user");
                        }
                    }
                }
            }
        }
        getUsersList(request);
        request.getRequestDispatcher("/WEB-INF/pages/users.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Boolean isAdmin = false;
        if ((Boolean)request.getSession().getAttribute("admin")) {
            isAdmin = (Boolean)request.getSession().getAttribute("admin");
        }

        if (isAdmin) {
            getUsersList(request);
            request.getRequestDispatcher("/WEB-INF/pages/users.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(request, response);
        }
    }

    private void getUsersList(HttpServletRequest request) {
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
    }
}
