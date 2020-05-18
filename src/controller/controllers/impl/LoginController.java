package controller.controllers.impl;

import controller.controllers.Controller;
import model.dao.UserDao;
import model.dao.impl.AdminDAOimpl;
import model.dao.impl.InstructorDAOimpl;
import model.dao.impl.StudentDAOIMpl;


import java.util.HashMap;
import java.util.Map;

public class LoginController implements Controller {

    private UserDao getUser(String userName){
        switch (userName){
            case "student": return new StudentDAOIMpl();

            case "admin":return new AdminDAOimpl();

            case "instructor":return new InstructorDAOimpl();


        }
        return null;
    }

    @Override
    public boolean requireAuthentication(String userName,String email,String password) {
        return getUser(userName).authentication(email, password);
    }

    @Override
    public String serve(Map<String, String> params,String userName,String email,String password) {
        if (requireAuthentication(userName,email,password)){
            return "you are successfully logged in with userName: "+userName+" email:"+email;
        }
        return "the email or password is not found";


    }

    @Override
    public Map<String, String> parse(String command) {
        Map<String, String> serviceParams = new HashMap<>();

        String[] param = command.split(" ");
        String studentId = param[1];
        String password = param[2];
       // serviceParams.put();
        //serviceParams.put();
        return serviceParams;
    }
}
