package app.servlets;
import app.dao.UserDAOImplementation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAOImplementation model = UserDAOImplementation.getInstance();
        String id = request.getParameter("buttonDeleteValue");
        if(id != null) {
            model.deleteUser(Integer.parseInt(id));
        }


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/delete.jsp");
        requestDispatcher.forward(request, response);


    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/add.jsp");

    }
}