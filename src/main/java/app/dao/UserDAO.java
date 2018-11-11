package app.dao;

import java.util.List;

import app.entities.User;


public interface UserDAO {
    public void addUser( User user );
    public void deleteUser( int user_id );
    public void updateUser( User user );
    public List<User> getAllUsers();
    public User getUserById( int user_id );
}
//
