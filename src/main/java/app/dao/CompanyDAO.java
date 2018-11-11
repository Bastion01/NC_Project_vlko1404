package app.dao;

import java.util.List;

import app.entities.Company;

//
public interface CompanyDAO {
    public void addCompany( Company company );
    public void deleteCompany( int id );
    public void updateCompany( Company company );
    public List<Company> getAllCompanies();
    public Company getCompanyById( int id );
}
