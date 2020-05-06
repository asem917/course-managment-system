package controller.controllers.impl;

import controller.controllers.Controller;



import java.util.HashMap;
import java.util.Map;

public class LoginController implements Controller {

    @Override
    public boolean requireAuthentication() {
        return false;
    }

    @Override
    public String serve(Map<String, String> params) {
   return "";
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
