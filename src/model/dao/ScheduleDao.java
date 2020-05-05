package model.dao;



import model.entity.Courses;
import model.entity.Schedule;

import java.sql.SQLException;

public interface ScheduleDao {
    void save(Schedule schedule) throws SQLException;
    void update(Schedule schedule);
    void delete(int id);
    Schedule listOf(Courses courses);

}
