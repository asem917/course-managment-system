package model.dao;


import model.entity.Courses;

import java.sql.SQLException;

public interface CourseDAO {

    Courses findById(int id) throws SQLException;
    void deleteCourse(int id) throws SQLException;
    void creat(Courses courses) throws SQLException;
    void update(Courses courses);

}
