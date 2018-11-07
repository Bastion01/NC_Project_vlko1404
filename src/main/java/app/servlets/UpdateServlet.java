package app.servlets;
import app.dao.UserDAOImplementation;
import app.entities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateServlet extends HttpServlet {
    int id_user = 0;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("pass");
        String buttonvalue = request.getParameter("buttonUpdateValue");
        request.setAttribute("userName", name);
        if(buttonvalue != null) {
            id_user = Integer.parseInt(buttonvalue);
        }

        request.setAttribute("buttonUpdateValue",buttonvalue);
        if((Integer)id_user!=null) {
            User user = new User(id_user, name, password);

            UserDAOImplementation model = UserDAOImplementation.getInstance();
            model.updateUser(user);
        }


        doGet(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/update.jsp");
        requestDispatcher.forward(request, response);
    }
}