package controller.controllers.impl;

import controller.controllers.Controller;
import model.dao.impl.AdminDAOimpl;
import model.dao.impl.CourseDAOImpl;

import java.sql.SQLException;
import java.util.Map;

public class DeleteCourseController implements Controller {
    AdminDAOimpl adminDAOimpl=new AdminDAOimpl();
    CourseDAOImpl courseDAOImpl=new CourseDAOImpl();
    @Override
    public boolean requireAuthentication(String userName, String email, String password) {
        return adminDAOimpl.authentication(email,password,userName);
    }

    @Override
    public String serve(Map<String, String> params, String userName, String email, String password) throws SQLException {
        if (requireAuthentication(userName,email,password)){
        courseDAOImpl.deleteCourse(params.get("courseId"));
        return "the course has been deleted";}
        return "you are not authorized";
    }

    @Override
    public Map<String, String> parse(String command) {
        return null;
    }
}
