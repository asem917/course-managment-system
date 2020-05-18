package model.dao;

import model.entity.User;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserDao {
    boolean authentication(String email, String password,String sqlStatement);
    void signUp(User user,String sqlStatement) throws SQLException;
    Connection getConnection() throws SQLException;
}
