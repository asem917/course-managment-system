package model.dao;



import model.entity.Courses;
import model.entity.Student;

import java.sql.SQLException;

public interface InstructorDao {
    void studentsAttendance(Courses courses,Student student) throws SQLException;
    void addStudent(Courses courses, Student student) throws SQLException;
    void removeStudent(Courses courses, Student student) throws SQLException;
    void modifyStudent(Student student);

}
