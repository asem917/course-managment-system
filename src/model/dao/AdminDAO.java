package model.dao;




import model.entity.Courses;
import model.entity.Instructor;
import model.entity.Reports;

import java.sql.SQLException;

public interface AdminDAO {
    void addInstructor(Instructor instructor) throws SQLException;
    void addCourse(Courses courses) throws SQLException;
    void assignInstructor(Instructor instructor, Courses courses) throws SQLException;
    Reports viewReport(int id) throws SQLException;
}
