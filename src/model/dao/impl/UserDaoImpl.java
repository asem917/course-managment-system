package model.dao.impl;

import model.dao.UserDao;
import model.dao.utils.DataSourcePool;
import model.entity.Student;
import model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private DataSourcePool dataSourcePool;




    @Override
    public boolean authentication(String email, String password,String sqlStatement) {
        boolean status=false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select* from course_managment_system.admin   where  password =? and email= ?");
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                status=true;
        }
        catch (SQLException e){

            e.printStackTrace(); }
        return status;
    }

    @Override
    public void signUp(User user, String sqlStatement) throws SQLException {
        Connection connection=getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("insert into course_managment_system.student (idstudent, first_name, last_name, email, password, join_year) values (?,?,?,?,?,?)");
        preparedStatement.setInt(1, user.getId());
        preparedStatement.setString(2,user.getFirstName());
        preparedStatement.setString(3,user.getLastName());
        preparedStatement.setString(4,user.getEmail());
        preparedStatement.setString(5,user.getPassword());


        preparedStatement.executeUpdate();
        connection.close();

    }

    @Override
    public Connection getConnection() throws SQLException {
        return dataSourcePool.getWraperConnections().getConnection();

        }
    }



