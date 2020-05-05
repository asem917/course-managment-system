package model.entity;

public class Reports {
    private int reportId;
    private String reportText;
    private int idStudentInCourse;

    public Reports(int reportId, String reportText, int idStudentInCourse) {
        this.reportId = reportId;
        this.reportText = reportText;
        this.idStudentInCourse = idStudentInCourse;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getReportText() {
        return reportText;
    }

    public void setReportText(String reportText) {
        this.reportText = reportText;
    }

    public int getIdStudentInCourse() {
        return idStudentInCourse;
    }

    public void setIdStudentInCourse(int idStudentInCourse) {
        this.idStudentInCourse = idStudentInCourse;
    }
}
