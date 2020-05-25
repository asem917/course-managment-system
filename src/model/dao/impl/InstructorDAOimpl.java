package model.dao.impl;


import model.dao.InstructorDao;
import model.dao.UserDao;
import model.dao.utils.DataSourcePool;
import model.entity.Courses;
import model.entity.Student;
import model.entity.User;

import java.sql.*;

public class InstructorDAOimpl extends UserDaoImpl implements InstructorDao {




    @Override
    public void studentsAttendance(String courseId,String studentId) throws SQLException {
        PreparedStatement preparedStatement=getConnection().prepareStatement("insert  into course_managment_system.attendance(idstudent_fk, idcourse_fk) values (?,?)");
        preparedStatement.setString(1,studentId);
        preparedStatement.setString(2,courseId);
        preparedStatement.executeUpdate();
        getConnection().close();



    }

    @Override
    public void addStudent(String courseId,String studentId) throws SQLException {
        PreparedStatement preparedStatement=getConnection().prepareStatement("insert  into course_managment_system.schedule(student_id_fk, course_id_fk) values (?,?)");
        preparedStatement.setString(1,studentId);
        preparedStatement.setString(2,courseId);
        preparedStatement.executeUpdate();
        getConnection().close();

    }

    @Override
    public void removeStudent(String courseId,String studentId) throws SQLException {


        PreparedStatement p=getConnection().prepareStatement("delete from course_managment_system.schedule where course_id_fk=? and student_id_fk=?");
        p.setString(1,courseId);
        p.setString(2,studentId);
        p.executeUpdate();
        getConnection().close();

    }

    @Override
    public Student modifyStudent(String studentId) throws SQLException {
        PreparedStatement preparedStatement=getConnection().prepareStatement("select *from course_managment_system.student where student.idstudent=?");
        preparedStatement.setString(1,studentId);
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        Student student=new Student(studentId,resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5));
        PreparedStatement p=getConnection().prepareStatement("delete from course_managment_system.student where student.idstudent=?");
        p.setString(1,studentId);
        p.executeUpdate();
        getConnection().close();
        return student;

    }





}
