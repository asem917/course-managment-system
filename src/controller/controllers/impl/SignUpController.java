package controller.controllers.impl;

import controller.controllers.Controller;
import model.dao.impl.UserDaoImpl;
import model.dao.utils.UserDaoImplFactory;
import model.entity.User;


import java.util.Map;

public class SignUpController implements Controller {


    @Override
    public boolean requireAuthentication(String userName, String email, String password) {
        return false;
    }

    @Override
    public String serve(Map<String, String> params, String userName, String email, String password) {
      UserDaoImpl userDaoImpl= UserDaoImplFactory.getUserDaoImpl(userName);
        User user=new User(params.get("id"),params.get("firstName"),params.get("lastName"),params.get("email"),params.get("password"));
      userDaoImpl.signUp(user,userName);
      return "";
    }

    @Override
    public Map<String, String> parse(String command) {
        return null;
    }
}
