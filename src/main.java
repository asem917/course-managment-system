import model.dao.InstructorDao;
import model.dao.impl.AdminDAOimpl;
import model.dao.impl.CourseDAOImpl;
import model.dao.impl.InstructorDAOimpl;
import model.dao.impl.StudentDAOIMpl;
import model.entity.Courses;
import model.entity.Instructor;
import model.entity.Student;

import java.sql.SQLException;

public class main {
    public static void main(String[] args) {

     //   AdminDAOimpl a=new AdminDAOimpl("root","root@JEA","localhost","course_managment_system");
       // Instructor i=new Instructor(2,"asem","tbaileh","asd@asd.as","asdasd");
       // Courses courses=new Courses(6,"java","ali");
       // InstructorDAOimpl instructorDAOimpl=new InstructorDAOimpl("root","root@JEA","localhost","course_managment_system");
       // CourseDAOImpl courseDAOimpl=new CourseDAOImpl("root","root@JEA","localhost","course_managment_system");
       // Student student=new Student(6,"ali","sdsd","asdas@xv","asdczdc","2019");
        StudentDAOIMpl studentDAOIMpl=new StudentDAOIMpl("root","root@JEA","localhost","course_managment_system");

        try {
            System.out.println(  studentDAOIMpl.logIn("ghg","fghfg"));





    }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
