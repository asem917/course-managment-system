package model.dao.impl;

import model.dao.UserDao;
import model.dao.utils.DataSourcePool;
import model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private DataSourcePool dataSourcePool=new DataSourcePool();




    @Override
    public boolean authentication(String email, String password,String userName) {
        String sqlStatement="select* from course_managment_system."+userName+"  where  password =? and email= ?";
        boolean status=false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
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
    public void signUp(User user, String userName)  {
        try {
            Connection connection=getConnection();
        if (!authentication(user.getEmail(),user.getPassword(),userName)) {
            PreparedStatement preparedStatement;
            switch (userName) {
                case "instructor":
                    preparedStatement = getConnection().prepareStatement("insert  into course_managment_system.instructor (idinstructor, first_name, last_name, email, password) values (?,?,?,?,?)");
                    break;
                case "student":
                    preparedStatement = getConnection().prepareStatement("insert  into course_managment_system.student (idstudent, first_name, last_name, email, password) values (?,?,?,?,? )");
                    break;
                default:
                    preparedStatement = null;
            }


            preparedStatement.setString(1, user.getId());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPassword());

            preparedStatement.executeUpdate();
        }else System.out.println("you are already logged in ");

        connection.close();}catch (SQLException ex){
            ex.printStackTrace();
        }

    }

    @Override
    public Connection getConnection() throws SQLException {
        return dataSourcePool.getWraperConnections().getConnection();

        }
    }



