package app.servlets;
import app.dao.CompanyDAOImplementation;
import app.entities.Company;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateCompanyServlet extends HttpServlet {
    int id = 0;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String workers_number = request.getParameter("workers_number");
        String buttonvalue = request.getParameter("buttonUpdateValue");
        String rating = request.getParameter("rating");
        request.setAttribute("companyName", name);


        if(buttonvalue != null) {
            id = Integer.parseInt(buttonvalue);
        }
        //

        request.setAttribute("buttonUpdateValue",buttonvalue);

        try{
            CompanyDAOImplementation model = CompanyDAOImplementation.getInstance();
            Company company = new Company(id, name, Integer.parseInt(workers_number),Integer.parseInt(rating));

            model.updateCompany(company);

        }catch (Exception e)
        {
            System.out.println(e.getMessage());

        }


        doGet(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/updatecompany.jsp");
        requestDispatcher.forward(request, response);
    }
}