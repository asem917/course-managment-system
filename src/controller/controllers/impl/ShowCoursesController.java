package controller.controllers.impl;

import controller.controllers.Controller;


import java.util.Map;

public class ShowCoursesController implements Controller {

    @Override
    public boolean requireAuthentication() {
        return false;
    }

    @Override
    public String serve(Map<String, String> params) {
        System.out.println("This is show courses service");
        return null;
    }

    @Override
    public Map<String, String> parse(String command) {
        return null;
    }
}
