package model.dao;


import model.entity.Courses;

import java.sql.SQLException;

public interface CourseDAO {

    Courses findById(String id) throws SQLException;
    void deleteCourse(String id) throws SQLException;
    void creat(Courses courses) throws SQLException;
    Courses update(String courseId);

}
