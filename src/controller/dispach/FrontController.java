package controller.dispach;



import controller.controllers.Controller;

import java.util.Map;


public class FrontController {

    /*public void dispatch(String command) {
        String controllerName = command.split(" ")[0];


    Controller controller = ServiceLocator.getController(controllerName);
        if(controller == null) {
            throw new UnsupportedOperationException(controllerName + " - is Not Supported");
        }
        Map<String, String> params = controller.parse(command);
        if(controller.requireAuthentication()) {
            boolean authenticated =
                    AuthenticationUtil.isAuthenticated(params.get(
                            Constants.STUDENT_ID.getValue()), params.get(Constants.TOKEN.getValue()));
            // Make sure that the user is logged in
        }
        System.out.println(service.serve(params));*/
}
