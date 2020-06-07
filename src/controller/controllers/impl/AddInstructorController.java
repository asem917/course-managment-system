package controller.controllers.impl;

import controller.controllers.Controller;
import model.dao.impl.AdminDAOimpl;
import model.dao.impl.InstructorDAOimpl;
import model.entity.Instructor;

import java.sql.SQLException;
import java.util.Map;

public class AddInstructorController implements Controller {
    private AdminDAOimpl adminDAOimpl=new AdminDAOimpl();
    private Instructor instructor;


    @Override
    public boolean requireAuthentication(String userName, String email, String password) {
        return adminDAOimpl.authentication(email,password,userName);
    }

    @Override
    public String serve(Map<String, String> params, String userName, String email, String password) throws SQLException {
        if (requireAuthentication(userName,email,password)){
            instructor=new Instructor(params.get("InstructorId"),params.get("firstName"),params.get("lastName"),params.get("email"),params.get("password"));

            adminDAOimpl.addInstructor(instructor);
            return "instructor has been add successfully";
        }
        return "you are not authorized";
    }

    @Override
    public Map<String, String> parse(String command) {
        return null;
    }
}
