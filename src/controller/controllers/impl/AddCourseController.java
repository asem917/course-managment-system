package controller.controllers.impl;

import controller.controllers.Controller;
import model.dao.impl.AdminDAOimpl;
import model.dao.impl.CourseDAOImpl;
import model.dao.impl.StudentDAOIMpl;
import model.entity.Courses;

import java.sql.SQLException;
import java.util.Map;

public class AddCourseController implements Controller {
   private AdminDAOimpl adminDAOimpl=new AdminDAOimpl();
   private CourseDAOImpl courseDAOImpl=new CourseDAOImpl();



    @Override
    public boolean requireAuthentication(String userName, String email, String password) {

        return adminDAOimpl.authentication(email,password,userName);
    }

    @Override
    public String serve(Map<String, String> params, String userName, String email, String password) throws SQLException {
        if (requireAuthentication(userName, email, password)) {
            Courses courses=new Courses(params.get("courseId"),params.get("courseName"),params.get("teacherName"));
            courseDAOImpl.creat(courses);
            return "the course has been added successfully";

        }
        return "you are not  authorized";

    }

    @Override
    public Map<String, String> parse(String command) {
        return null;
    }
}
