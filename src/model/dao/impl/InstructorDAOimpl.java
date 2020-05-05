package model.dao.impl;


import model.dao.InstructorDao;
import model.dao.utils.DataSourcePool;
import model.entity.Courses;
import model.entity.Student;

import java.sql.*;

public class InstructorDAOimpl implements InstructorDao {
    private String userName;
    private String passwored;
    private String host;
    private String databaseName;
    private DataSourcePool dataSourcePool;

    public InstructorDAOimpl(String userName, String passwored, String host, String databaseName) {
        this.userName = userName;
        this.passwored = passwored;
        this.host = host;
        this.databaseName = databaseName;
        this.dataSourcePool=new DataSourcePool(userName,passwored,host,databaseName);
    }

    public Connection getConnection() throws SQLException {

        return dataSourcePool.getConnections().getConnection();}
    @Override
    public void studentsAttendance(Courses courses,Student student) throws SQLException {
        PreparedStatement preparedStatement=getConnection().prepareStatement("insert  into course_managment_system.attendance(idstudent_fk, idcourse_fk) values (?,?)");
        preparedStatement.setInt(1,student.getId());
        preparedStatement.setInt(2,courses.getCourseId());
        preparedStatement.executeUpdate();
        getConnection().close();



    }

    @Override
    public void addStudent(Courses courses, Student student) throws SQLException {
        PreparedStatement preparedStatement=getConnection().prepareStatement("insert  into course_managment_system.schedule(student_id_fk, course_id_fk) values (?,?)");
        preparedStatement.setInt(1,student.getId());
        preparedStatement.setInt(2,courses.getCourseId());
        preparedStatement.executeUpdate();
        getConnection().close();

    }

    @Override
    public void removeStudent(Courses courses, Student student) throws SQLException {
        int courseID=courses.getCourseId();
        int studentID=student.getId();

        PreparedStatement p=getConnection().prepareStatement("delete from course_managment_system.schedule where course_id_fk=? and student_id_fk=?");
        p.setInt(1,courseID);
        p.setInt(2,studentID);
        p.executeUpdate();
        getConnection().close();

    }

    @Override
    public void modifyStudent(Student student) {


    }
}
