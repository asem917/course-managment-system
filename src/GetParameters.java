import controller.controllers.impl.SignUpController;
import model.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "GetParameters",urlPatterns = "/GetParameters")
public class GetParameters extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        init();
        String id= request.getParameter("id");
        String fName= request.getParameter("firstName");
        String lastName= request.getParameter("lastName");
        String email= request.getParameter("email");
        String password= request.getParameter("password");
        Map<String,String> pa=new HashMap<>();
        pa.put("id",id);
        pa.put("firstName",fName);
        pa.put("lastName",lastName);
        pa.put("email",email);
        pa.put("password",password);
        SignUpController signUpController=new SignUpController();
        signUpController.serve(pa,"instructor",email,password);
        out.close();


    }
    public void init () throws ServletException {
        UserDaoImpl userDao=new UserDaoImpl();

        try {
            userDao.getConnection();

        }
        catch (Exception e){e.printStackTrace();}
    }

}
