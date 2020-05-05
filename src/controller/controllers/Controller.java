package controller.controllers;

import java.util.Map;

public interface Controller {

    boolean requireAuthentication();

    String serve(Map<String, String> params);

    Map<String, String> parse(String command);
}
