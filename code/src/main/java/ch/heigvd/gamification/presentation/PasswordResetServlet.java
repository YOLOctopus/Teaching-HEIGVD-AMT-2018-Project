package ch.heigvd.gamification.presentation;

import ch.heigvd.gamification.business.RegisterConfirmation;
import ch.heigvd.gamification.dao.BusinessDomainEntityNotFoundException;
import ch.heigvd.gamification.dao.UserTokenManagerLocal;
import ch.heigvd.gamification.dao.UsersManagerLocal;
import ch.heigvd.gamification.model.User;
import ch.heigvd.gamification.model.UserToken;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PasswordResetServlet")
public class PasswordResetServlet extends HttpServlet {
    @EJB
    UserTokenManagerLocal userTokenManager;

    @EJB
    UsersManagerLocal usersManager;

    @EJB
    RegisterConfirmation registerConfirmation;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newPassword = request.getParameter("newPassword");
        String passwordRepeat = request.getParameter("passwordRepeat");
        Long id = Long.parseLong(request.getParameter("userId"));
        if (!newPassword.equals(passwordRepeat)) {
            request.setAttribute("userId", id);
            request.setAttribute("error", "Please type the same password twice.");
            request.setAttribute("success", false);
        } else {
            if (registerConfirmation.validPassword(newPassword)) {
                try {
                    User user = usersManager.findById(id);
                    user.setPassword(newPassword);
                    user.setMustResetPassword(false);
                    usersManager.update(user);
                    request.setAttribute("success", true);
                } catch (BusinessDomainEntityNotFoundException e) {
                    //TODO: log
                }
            } else {
                request.setAttribute("userId", id);
                request.setAttribute("error", "Password must be 7 characters minimum");
                request.setAttribute("success", false);
            }
        }
        request.getRequestDispatcher("/WEB-INF/pages/passwordreset.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserToken userToken = null;
        if (request.getParameterMap().containsKey("token")) {
            String token = request.getParameter("token");
            userToken = userTokenManager.findByToken(token);
        }
        if (request.getParameterMap().containsKey("userId")) {
            Long userId = Long.parseLong(request.getParameter("userId"));
            try {
                userToken = userTokenManager.findByUser(usersManager.findById(userId));
            } catch (BusinessDomainEntityNotFoundException e) {
                //TODO: log
            }
        }
        request.setAttribute("userId", userToken.getUser().getId());
        request.getRequestDispatcher("/WEB-INF/pages/passwordreset.jsp").forward(request, response);
    }
}
