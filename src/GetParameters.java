import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetParameters",urlPatterns = "/GetParameters")
public class GetParameters extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String lName= request.getParameter("lastName");
        String fName= request.getParameter("firstName");
        String mi= request.getParameter("mi");
        out.println("<h1>Welcome on board  " +fName + " " + mi+ " " +
                lName  + "</h1>");
        out.close();

    }
}
