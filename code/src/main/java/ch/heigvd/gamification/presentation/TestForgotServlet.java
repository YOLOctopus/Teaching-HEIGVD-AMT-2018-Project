package ch.heigvd.gamification.presentation;

import ch.heigvd.gamification.dao.UserTokenManagerLocal;
import ch.heigvd.gamification.dao.UsersManagerLocal;
import ch.heigvd.gamification.model.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TestForgotServlet")
public class TestForgotServlet extends HttpServlet {

    @EJB
    UserTokenManagerLocal userTokenManager;

    @EJB
    UsersManagerLocal usersManager;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        User user = usersManager.findByEmail(email);
        String userToken = userTokenManager.findByUser(user).getToken();
        request.setAttribute("token", userToken);
        request.getRequestDispatcher("/WEB-INF/pages/testforgot.jsp").forward(request, response);
    }
}
