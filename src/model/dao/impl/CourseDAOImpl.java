package model.dao.impl;


import model.dao.CourseDAO;
import model.dao.utils.DataSourcePool;
import model.entity.Courses;

import java.sql.*;

public class CourseDAOImpl implements CourseDAO {

    private DataSourcePool dataSourcePool;


    public CourseDAOImpl() {

        this.dataSourcePool=new DataSourcePool();

    }

    public Connection getConnection() throws SQLException {

        return dataSourcePool.getWraperConnections().getConnection();

    }





    @Override
    public Courses findById(String id) throws SQLException {
        String sql="select *from student2.course where course.courseId="+id+"";

        PreparedStatement preparedStatement=getConnection().prepareStatement(sql);
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        String iD=resultSet.getString(1);
        String name=resultSet.getString(2);
        String teacherName=resultSet.getString(3);
        Courses courses=new Courses(iD,name,teacherName);
        getConnection().close();
        return courses;
    }

    @Override
    public void deleteCourse(String id) throws SQLException {
        String sql="delete from student2.course where courseId="+id+"";
        Statement statement=getConnection().createStatement();
        int resultSet=statement.executeUpdate(sql);
        getConnection().close();

    }

    @Override
    public void creat(Courses courses) throws SQLException {

        String iD=courses.getCourseId();
        String name=courses.getCourseName();
        String teName=courses.getTeacherName();
        PreparedStatement preparedStatement=getConnection().prepareStatement("insert  into course_managment_system.course (idcourse, course_name, instractor_name) values (?,?,?)");
        preparedStatement.setString(1,iD);
        preparedStatement.setString(2,name);
        preparedStatement.setString(3,teName);
        preparedStatement.executeUpdate();
        getConnection().close();

    }

    @Override
    public Courses update(String courseId) {
        return null;

    }
}
