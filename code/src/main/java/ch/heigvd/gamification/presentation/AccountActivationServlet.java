/**
 * @document AccountActivationServlet
 * @date 28.10.2018
 * @author Samuel Mayor, Alexandra Korukova, Pierre-Samuel Rochat and Arnold von Bauer Gauss
 * @Goal Process requests for the account confirmation page
 */

package ch.heigvd.gamification.presentation;

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

@WebServlet(name = "AccountActivationServlet")
public class AccountActivationServlet extends HttpServlet {
    @EJB
    UserTokenManagerLocal userTokenManager;

    @EJB
    UsersManagerLocal usersManager;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token = request.getParameter("token");
        UserToken userToken = userTokenManager.findByToken(token);
        User user = userToken.getUser();
        user.setActive(true);
        try {
            usersManager.update(user);
        } catch (BusinessDomainEntityNotFoundException e) {
            //TODO: log
        }
        request.getRequestDispatcher("/WEB-INF/pages/accountactivation.jsp").forward(request, response);
    }
}
