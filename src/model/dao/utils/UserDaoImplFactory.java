package model.dao.utils;

import model.dao.impl.AdminDAOimpl;
import model.dao.impl.InstructorDAOimpl;
import model.dao.impl.StudentDAOIMpl;
import model.dao.impl.UserDaoImpl;

public class UserDaoImplFactory {

    public static UserDaoImpl getUserDaoImpl(String userName){
        switch (userName){
            case "admin": return new AdminDAOimpl();
            case "instructor":return new InstructorDAOimpl();
            case "student":return new StudentDAOIMpl();
            default:return null;
        }
    }
}
