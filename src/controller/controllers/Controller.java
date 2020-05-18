package controller.controllers;

import com.sun.xml.internal.ws.server.ServerRtException;

import java.util.Map;

public interface Controller {

    boolean requireAuthentication(String userName, String email, String password);

    String serve(Map<String, String> params,String userName,String email,String password);

    Map<String, String> parse(String command);
}
