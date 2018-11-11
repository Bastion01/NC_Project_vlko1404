package app.servlets;
import app.dao.UserDAOImplementation;
import app.entities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class JoinServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAOImplementation model = UserDAOImplementation.getInstance();
        List<User> users = model.getJoin();
        request.setAttribute("joinNames", users);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/joinlist.jsp");
        requestDispatcher.forward(request, response);
    }
}
//