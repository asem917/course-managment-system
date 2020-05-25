import com.mysql.cj.conf.url.SingleConnectionUrl;
import controller.controllers.impl.AddCourseController;
import controller.controllers.impl.LoginController;
import controller.controllers.impl.SignUpController;
import model.dao.InstructorDao;
import model.dao.impl.AdminDAOimpl;
import model.dao.impl.CourseDAOImpl;
import model.dao.impl.InstructorDAOimpl;
import model.dao.impl.StudentDAOIMpl;
import model.entity.Courses;
import model.entity.Instructor;
import model.entity.Student;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) throws SQLException {

        //   AdminDAOimpl a=new AdminDAOimpl("root","root@JEA","localhost","course_managment_system");
        // Instructor i=new Instructor(2,"asem","tbaileh","asd@asd.as","asdasd");
        // Courses courses=new Courses(6,"java","ali");
        // InstructorDAOimpl instructorDAOimpl=new InstructorDAOimpl("root","root@JEA","localhost","course_managment_system");
        // CourseDAOImpl courseDAOimpl=new CourseDAOImpl("root","root@JEA","localhost","course_managment_system");
        // Student student=new Student(6,"ali","sdsd","asdas@xv","asdczdc","2019");

    Map<String,String> pa=new HashMap<>();
    pa.put("id","55");
        pa.put("firstName","adnan");
        pa.put("lastName","alala");
        pa.put("email","asdadf@asd.com");
        pa.put("password","8888");
        SignUpController signUpController=new SignUpController();
        signUpController.serve(pa,"student","asdadf@asd.com","8888");





    }
}