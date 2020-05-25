package model.dao;



import model.entity.Courses;
import model.entity.Student;

import java.sql.SQLException;

public interface InstructorDao {
    void studentsAttendance(String courseId,String studentId) throws SQLException;
    void addStudent(String courseId,String studentId) throws SQLException;
    void removeStudent(String courseId,String studentId) throws SQLException;
    Student modifyStudent(String studentId) throws SQLException;

}
