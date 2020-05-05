package model.entity;

public class Schedule {

    String studentId;
    int coursesId;

    public Schedule(String studentId, int coursesId) {
        this.studentId = studentId;
        this.coursesId = coursesId;
    }

    public String getStudentId() {
        return studentId;
    }

    public int getCoursesId() {
        return coursesId;
    }
}
