package controller.dispach;

import services.Service;
import util.AuthenticationUtil;
import util.Constants;

import java.util.Map;

public class FrontController {

    public void dispatch(String command) {
        String serviceName = command.split(" ")[0];
        Service service = ServiceLocator.getService(serviceName);
        if(service == null) {
            throw new UnsupportedOperationException(serviceName + " - is Not Supported");
        }
        Map<String, String> params = service.parse(command);
        if(service.requireAuthentication()) {
            boolean authenticated =
                    AuthenticationUtil.isAuthenticated(params.get(
                            Constants.STUDENT_ID.getValue()), params.get(Constants.TOKEN.getValue()));
            // Make sure that the user is logged in
        }
        System.out.println(service.serve(params));
    }
}
