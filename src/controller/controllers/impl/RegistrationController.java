package controller.controllers.impl;

import controller.controllers.Controller;



import java.util.HashMap;
import java.util.Map;

public class RegistrationController implements Controller {

    @Override
    public boolean requireAuthentication() {
        return true;
    }

    @Override
    public String serve(Map<String, String> params) {
        System.out.println("This is registration service");
        return "";
    }

    @Override
    public Map<String, String> parse(String command) {
        Map<String, String> params = new HashMap<>();

       // params.put(Constants.TOKEN.getValue(), "");
        //params.put(Constants.STUDENT_ID.getValue(), "");
        //params.put(Constants.COURSE_ID.getValue(), "");
        return null;
    }
}
