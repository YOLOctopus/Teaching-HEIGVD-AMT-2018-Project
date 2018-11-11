package ch.heigvd.gamification.presentation;

import ch.heigvd.gamification.dao.UserTokenManagerLocal;
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token = request.getParameter("token");
        UserToken userToken = userTokenManager.findByToken(token);
        userToken.getUser().setActive(true);
        request.getRequestDispatcher("/WEB-INF/pages/accountactivation.jsp").forward(request, response);
    }
}
