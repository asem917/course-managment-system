package model.dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;


public class WraperConnection {
    private String userName="root";
    private String passwored="root@JEA";
    private String host="localhost";
    private String databaseName="course_managment_system";
    private Connection connection;
    private LocalDateTime c;

    public WraperConnection() throws SQLException {

        this.c=LocalDateTime.now();
        try {


            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        this.connection= DriverManager.getConnection("jdbc:mysql://"+host+":3306/"+databaseName,userName,passwored);


    }

    public LocalDateTime getC() {
        return c;
    }

    public Connection getConnection() {
        return connection;
    }
}


