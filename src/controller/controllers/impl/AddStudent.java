package controller.controllers.impl;

import controller.controllers.Controller;
import model.dao.impl.InstructorDAOimpl;
import model.dao.impl.StudentDAOIMpl;
import model.entity.Instructor;
import model.entity.Student;

import java.sql.SQLException;
import java.util.Map;

public class AddStudent implements Controller {

    private Student student;
    private InstructorDAOimpl instructorDAOimpl=new InstructorDAOimpl();

    @Override
    public boolean requireAuthentication(String userName, String email, String password) {
        return instructorDAOimpl.authentication(email,password,"instructor");
    }

    @Override
    public String serve(Map<String, String> params, String userName, String email, String password) throws SQLException {
        if (requireAuthentication("instructor",email,password)){
            student=new Student(params.get("idStudent"),params.get("firstName"),params.get("lastName"),params.get("email"),params.get("password"),params.get("joinYear"));


        }
        return "";
    }

    @Override
    public Map<String, String> parse(String command) {
        return null;
    }
}
