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

public class UpdateServlet extends HttpServlet {
    int id_user = 0;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("pass");
        String buttonvalue = request.getParameter("buttonUpdateValue");
        String company_id = request.getParameter("company");
        request.setAttribute("userName", name);


        if(buttonvalue != null) {
            id_user = Integer.parseInt(buttonvalue);
        }

        request.setAttribute("buttonUpdateValue",buttonvalue);
        if((Integer)id_user!=null && company_id!=null ) {
            User user = new User(id_user, name, password,Integer.parseInt(company_id));

            UserDAOImplementation model = UserDAOImplementation.getInstance();
            model.updateUser(user);
        }
        UserDAOImplementation model = UserDAOImplementation.getInstance();
       /* User initial_user = model.getUserById(id_user);
        request.setAttribute("initial_name",initial_user.getName());
        request.setAttribute("initial_password",initial_user.getPassword());
        request.setAttribute("initial_job",initial_user.getCompany_id());

        System.out.println(initial_user.getName());
        */
       //
        try{

            User user = new User(id_user, name, password,Integer.parseInt(company_id));

            model.updateUser(user);

        }catch (Exception e)
        {
            System.out.println(e.getMessage());

        }


        doGet(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CompanyDAOImplementation model = CompanyDAOImplementation.getInstance();
        List<Company> companies = model.getAllCompanies();
        request.setAttribute("companiesNames", companies);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/update.jsp");
        requestDispatcher.forward(request, response);
    }
}