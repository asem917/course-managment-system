package model.dao.impl;


import model.dao.ScheduleDao;
import model.dao.utils.DataSourcePool;
import model.entity.Courses;
import model.entity.Schedule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ScheduleDaoImpl implements ScheduleDao {


    private DataSourcePool dataSourcePool;

    public ScheduleDaoImpl() {

        this.dataSourcePool=new DataSourcePool();

    }
    public Connection getConnection() throws SQLException {

        return dataSourcePool.getWraperConnections().getConnection();

    }



    @Override
    public void save(Schedule schedule) throws SQLException {
        String student=schedule.getStudentId();
        int course=schedule.getCoursesId();
        PreparedStatement preparedStatement=getConnection().prepareStatement("insert  into student2.schedule (studentId, courseId) values (?,?)");
        preparedStatement.setString(1,student);
        preparedStatement.setInt(2,course);
        preparedStatement.executeUpdate();

    }

    @Override
    public void update(Schedule schedule) {
        String sql="select *from student2.schedule where schedule.id="+schedule.getStudentId();
        Statement statement= null;
        try {
            statement = getConnection().createStatement();
            int resultSet=statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }









    }

    @Override
    public void delete(int id) {
        try {
            Statement statement=getConnection().createStatement();
            int resultSet=statement.executeUpdate("delete from student2.schedule where student2.schedule.studentId="+id);


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public Schedule listOf(Courses courses) {
        return null;
    }


}
