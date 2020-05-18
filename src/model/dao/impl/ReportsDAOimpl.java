package model.dao.impl;



import model.dao.ReportsDao;
import model.dao.utils.DataSourcePool;
import model.entity.Reports;

import java.sql.Connection;
import java.sql.SQLException;


public class ReportsDAOimpl implements ReportsDao {

    private DataSourcePool dataSourcePool;

    public ReportsDAOimpl() {

        this.dataSourcePool=new DataSourcePool();
    }

    public Connection getConnection() throws SQLException {

        return dataSourcePool.getWraperConnections().getConnection();}
        @Override
        public Reports allStudentsInCourse () {
            return null;
        }

        @Override
        public Reports coursesOfStudent () {
            return null;
        }
    }
