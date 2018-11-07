package app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.entities.User;
import app.util.DBUtil;


public class UserDAOImplementation implements UserDAO {
    private static UserDAOImplementation instance = new UserDAOImplementation();
    private Connection conn;
    public static UserDAOImplementation getInstance() {
        return instance;
    }

    public UserDAOImplementation() {
        conn = DBUtil.getConnection();
    }
    @Override
    public void addUser( User user ) {
        try {
            String query = "insert into peoples (fname, password ) values (?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString( 1, user.getName() );
            preparedStatement.setString( 2, user.getPassword() );
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void deleteUser( int User_id ) {
        try {
            String query = "delete from peoples where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, User_id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void updateUser( User user ) {
        try {
            String query = "update peoples set fname = ?,password = ? where id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString( 1, user.getName() );
            preparedStatement.setString( 2, user.getPassword() );
            preparedStatement.setInt(3,user.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery( "select * from peoples" );
            while( resultSet.next() ) {
                User user = new User();
                user.setId( resultSet.getInt( "id" ) );
                user.setName( resultSet.getString( "fname" ) );
                user.setPassword( resultSet.getString( "password" ) );
                users.add(user);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    @Override
    public User getUserById(int userId) {
        User user = new User();
        try {
            String query = "select * from peoples where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while( resultSet.next() ) {
                user.setId(resultSet.getInt("id"));
                user.setName( resultSet.getString( "fname" ) );
                user.setPassword( resultSet.getString( "password" ) );

            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}