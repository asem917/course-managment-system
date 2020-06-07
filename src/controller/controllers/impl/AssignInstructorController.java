package controller.controllers.impl;

import controller.controllers.Controller;
import model.dao.impl.AdminDAOimpl;

import java.sql.SQLException;
import java.util.Map;

public class AssignInstructorController implements Controller {
    AdminDAOimpl adminDAOimpl=new AdminDAOimpl();

    @Override
    public boolean requireAuthentication(String userName, String email, String password) {
        return adminDAOimpl.authentication(email,password,userName);
    }

    @Override
    public String serve(Map<String, String> params, String userName, String email, String password) throws SQLException {
        if (requireAuthentication(userName,email,password)){
            adminDAOimpl.assignInstructor(params.get("instructorId"),params.get("courseId"));

        return "the assigning instructor has been done";}
         return "you are not authorised"  ;  }

    @Override
    public Map<String, String> parse(String command) {
        return null;
    }
}
