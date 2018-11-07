package app.servlets;
import app.dao.UserDAOImplementation;
import app.entities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("pass");
        User user = new User(name, password);
        UserDAOImplementation model = UserDAOImplementation.getInstance();
        model.addUser(user);

        request.setAttribute("userName", name);
        doGet(request, response);
    }
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/add.jsp");
    requestDispatcher.forward(request, response);
    }
}