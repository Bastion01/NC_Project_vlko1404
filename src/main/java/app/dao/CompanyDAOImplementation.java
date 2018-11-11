package app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.entities.Company;
import app.util.DBUtil;


public class CompanyDAOImplementation implements CompanyDAO {
    private static CompanyDAOImplementation instance = new CompanyDAOImplementation();
    private Connection conn;
    public static CompanyDAOImplementation getInstance() {
        return instance;
    }

    public CompanyDAOImplementation() {
        conn = DBUtil.getConnection();
    }
    @Override
    public void addCompany( Company company ) {
        try {
            String query = "insert into companies (name, workers_number, rating ) values (?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString( 1, company.getName() );
            preparedStatement.setInt( 2, company.getWorkers() );
            preparedStatement.setInt(3, company.getRating());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void deleteCompany( int id ) {
        try {
            String query = "delete from companies where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void updateCompany( Company company ) {
        try {
            String query = "update companies set name = ?,workers_number = ?, rating = ? where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString( 1, company.getName() );
            preparedStatement.setInt( 2, company.getWorkers() );
            preparedStatement.setInt(3,company.getRating());
            preparedStatement.setInt(4,company.getJobId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //
    @Override
    public List<Company> getAllCompanies() {
        List<Company> companies = new ArrayList<Company>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery( "select * from companies" );
            while( resultSet.next() ) {
                Company company = new Company();
                company.setJobId( resultSet.getInt( "id" ) );
                company.setName( resultSet.getString( "name" ) );
                company.setWorkers( resultSet.getInt( "workers_number" ) );
                company.setRating(resultSet.getInt("rating"));
                companies.add(company);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companies;
    }
    @Override
    public Company getCompanyById(int id) {
        Company company = new Company();
        try {
            String query = "select * from companies where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while( resultSet.next() ) {
                company.setJobId( resultSet.getInt( "id" ) );
                company.setName( resultSet.getString( "name" ) );
                company.setWorkers( resultSet.getInt( "workers_number" ) );
                company.setRating(resultSet.getInt("rating"));

            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return company;
    }

}