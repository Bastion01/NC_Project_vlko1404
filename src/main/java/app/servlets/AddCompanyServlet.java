package app.servlets;
import app.dao.CompanyDAOImplementation;
import app.entities.Company;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddCompanyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String workers_number = request.getParameter("workers_number");
        String rating = request.getParameter("rating");
        Company company = new Company(name, Integer.parseInt(workers_number),  Integer.parseInt(rating));
        CompanyDAOImplementation model = CompanyDAOImplementation.getInstance();
        model.addCompany(company);

        request.setAttribute("companyName", name);
        doGet(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/addcompany.jsp");
        requestDispatcher.forward(request, response);
    }
}
//