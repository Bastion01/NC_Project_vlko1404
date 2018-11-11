package app.servlets;
import app.dao.CompanyDAOImplementation;
import app.dao.UserDAOImplementation;
import app.entities.Company;
import app.entities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("pass");
        String company_id = request.getParameter("company");



        User user = new User(name, password, Integer.parseInt(company_id));
        UserDAOImplementation model1 = UserDAOImplementation.getInstance();
        model1.addUser(user);

        request.setAttribute("userName", name);
        doGet(request, response);
    }
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    CompanyDAOImplementation model = CompanyDAOImplementation.getInstance();
    List<Company> companies = model.getAllCompanies();
    request.setAttribute("companiesNames", companies);

    RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/add.jsp");
    requestDispatcher.forward(request, response);
    }
}
//