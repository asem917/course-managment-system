package model.dao;


import model.entity.Reports;

public interface ReportsDao {
    Reports allStudentsInCourse();
    Reports coursesOfStudent();

}
