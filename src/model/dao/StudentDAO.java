package model.dao;


import model.entity.Courses;
import model.entity.Student;

import java.sql.SQLException;

public interface StudentDAO {
    void  registerCourse(int studentId,int courseId) throws SQLException;
    void viewCourses(int studentId) throws SQLException;
    void leaveCourse(int studentId,int courseId) throws SQLException;
    void viewStudentCourses(int studentId) throws SQLException;
    void viewAttendance(int studentId,int courseId) throws SQLException;
    void viewCourseFeedback(int studentId,int courseId) throws SQLException;
    void SignUp(Student student) throws SQLException;



}
