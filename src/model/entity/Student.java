package model.entity;

public class Student extends User {

   private String joinYear;


    public Student(String id, String firstName, String lastName, String email, String password, String joinYear) {
        super(id, firstName, lastName, email, password);
        this.joinYear = joinYear;
    }
}
