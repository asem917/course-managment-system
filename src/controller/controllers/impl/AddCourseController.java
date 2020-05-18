package controller.controllers.impl;

import controller.controllers.Controller;

import java.util.Map;

public class AddCourseController implements Controller {
    @Override
    public boolean requireAuthentication(String userName, String email, String password) {
        return false;
    }

    @Override
    public String serve(Map<String, String> params, String userName, String email, String password) {
        return null;
    }

    @Override
    public Map<String, String> parse(String command) {
        return null;
    }
}
