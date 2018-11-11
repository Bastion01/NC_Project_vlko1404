package app.servlets;
import app.dao.CompanyDAOImplementation;
import app.entities.Company;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListCompaniesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CompanyDAOImplementation model = CompanyDAOImplementation.getInstance();
        List<Company> companies = model.getAllCompanies();


        request.setAttribute("companiesNames", companies);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/listcompanies.jsp");
        requestDispatcher.forward(request, response);
    }
}
//
