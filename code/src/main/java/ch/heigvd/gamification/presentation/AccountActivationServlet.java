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
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "AccountActivationServlet")
public class AccountActivationServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(AccountActivationServlet.class.getName());

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
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }
        request.getRequestDispatcher("/WEB-INF/pages/accountactivation.jsp").forward(request, response);
    }
}
