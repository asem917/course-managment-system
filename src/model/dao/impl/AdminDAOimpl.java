package model.dao.impl;


import model.dao.AdminDAO;
import model.dao.UserDao;
import model.dao.utils.DataSourcePool;
import model.entity.Courses;
import model.entity.Instructor;
import model.entity.Reports;
import model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAOimpl extends UserDaoImpl implements AdminDAO {






    @Override
    public void addInstructor(Instructor instructor) throws SQLException {

        PreparedStatement preparedStatement=getConnection().prepareStatement("insert  into course_managment_system.instructor (idinstructor, first_name, last_name, email, password) values (?,?,?,?,?)");
        preparedStatement.setInt(1,instructor.getId());
        preparedStatement.setString(2,instructor.getFirstName());
        preparedStatement.setString(3,instructor.getLastName());
        preparedStatement.setString(4,instructor.getEmail());
        preparedStatement.setString(5,instructor.getPassword());
        preparedStatement.executeUpdate();
        getConnection().close();


    }

    @Override
    public void addCourse(Courses courses) throws SQLException {
        PreparedStatement preparedStatement=getConnection().prepareStatement("insert  into course_managment_system.course (idcourse, course_name, instractor_name) values (?,?,?)");
        preparedStatement.setInt(1,courses.getCourseId());
        preparedStatement.setString(2,courses.getCourseName());
        preparedStatement.setString(3,courses.getTeacherName());

        preparedStatement.executeUpdate();
        getConnection().close();

    }

    @Override
    public void assignInstructor(Instructor instructor, Courses courses) throws SQLException {
        PreparedStatement preparedStatement=getConnection().prepareStatement("insert  into course_managment_system.instructors_course (idinstructor_fk, idcourse) values (?,?)");
        preparedStatement.setInt(1,instructor.getId());
        preparedStatement.setInt(2,courses.getCourseId());
        preparedStatement.executeUpdate();
        getConnection().close();


    }

    @Override
    public Reports viewReport(int id) throws SQLException {

        String sql="select *from course_managment_system.report where report.idreport="+id+"";
        PreparedStatement preparedStatement=getConnection().prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        String reportText=resultSet.getString(1);
        int studentId=resultSet.getInt(2);
        Reports reports=new Reports(id,reportText,studentId);
        getConnection().close();
        return reports;
    }






}
