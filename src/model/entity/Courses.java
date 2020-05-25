package model.entity;

public class Courses {

   private String courseId;
   private String courseName;
   private String teacherName;

    public Courses(String courseId, String courseName, String teacherName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacherName = teacherName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", teacherName='" + teacherName + '\'' +
                '}';
    }
}
