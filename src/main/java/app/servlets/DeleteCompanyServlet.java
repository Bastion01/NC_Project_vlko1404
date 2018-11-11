package app.servlets;
import app.dao.CompanyDAOImplementation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCompanyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CompanyDAOImplementation model = CompanyDAOImplementation.getInstance();
        String id = request.getParameter("buttonDeleteValue");
        if(id != null) {
            model.deleteCompany(Integer.parseInt(id));
        }


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/deletecompany.jsp");
        requestDispatcher.forward(request, response);


    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
//