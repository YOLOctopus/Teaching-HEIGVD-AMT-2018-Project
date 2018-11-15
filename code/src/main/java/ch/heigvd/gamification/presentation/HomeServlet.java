/**
 * @document HomeServlet
 * @date 28.10.2018
 * @author Samuel Mayor, Alexandra Korukova, Pierre-Samuel Rochat and Arnold von Bauer Gauss
 * @Goal Process requests for the home page
 */

package ch.heigvd.gamification.presentation;

import ch.heigvd.gamification.dao.UsersManagerLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomeServlet")
public class HomeServlet extends HttpServlet {
    @EJB
    UsersManagerLocal usersManager;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(request, response);
    }
}
