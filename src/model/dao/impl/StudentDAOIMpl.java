package model.dao.impl;


import model.dao.StudentDAO;
import model.dao.UserDao;
import model.dao.utils.DataSourcePool;
import model.entity.Student;

import java.sql.*;

public class StudentDAOIMpl extends UserDaoImpl implements StudentDAO {







    @Override
    public void registerCourse(int studentId, int courseId) throws SQLException {
    Connection connection=getConnection();
    PreparedStatement preparedStatement=connection.prepareStatement("insert where into course_managment_system.schedule (student_id_fk, course_id_fk) VALUES (?,?) ");
    preparedStatement.setInt(1,studentId);
    preparedStatement.setInt(2,courseId);
    preparedStatement.executeUpdate();
    connection.close();

    }

    @Override
    public void viewCourses(int studentId) throws SQLException {
        Connection connection=getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("select *from course_managment_system.course ");
        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getInt(1)+"  "+resultSet.getString(2)+"  "+resultSet.getString(3));
        }


    }

    @Override
    public void leaveCourse(int studentId, int courseId) throws SQLException {
        Connection connection=getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("delete from course_managment_system.schedule where student_id_fk=? and course_id_fk=?");
        preparedStatement.setInt(1,studentId);
        preparedStatement.setInt(2,courseId);
        preparedStatement.executeUpdate();
        connection.close();


    }

    @Override
    public void viewStudentCourses(int studentId) throws SQLException {
        Connection connection=getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("select schedule.course_id_fk from course_managment_system.schedule ");
        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getInt(2));
        }



    }

    @Override
    public void viewAttendance(int studentId, int courseId) throws SQLException {
        Connection connection=getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("select attendance.number_of_attend from course_managment_system.attendance where idstudent_fk=? and idcourse_fk=?");
        preparedStatement.setInt(1,studentId);
        preparedStatement.setInt(2,courseId);
        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getInt(2));
        }

    }

    @Override
    public void viewCourseFeedback(int studentId, int courseId) throws SQLException {
        Connection connection=getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("select report.report_text from course_managment_system.report where idstudent_fk=? and idcourse_fk=?");
        preparedStatement.setInt(1,studentId);
        preparedStatement.setInt(2,courseId);
        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getInt(2));
        }

    }




}
