package model.dao.impl;



import model.dao.ReportsDao;
import model.dao.utils.DataSourcePool;
import model.entity.Reports;

import java.sql.Connection;
import java.sql.SQLException;


public class ReportsDAOimpl implements ReportsDao {
    private String userName;
    private String passwored;
    private String host;
    private String databaseName;
    private DataSourcePool dataSourcePool;

    public ReportsDAOimpl(String userName, String passwored, String host, String databaseName, DataSourcePool dataSourcePool) {
        this.userName = userName;
        this.passwored = passwored;
        this.host = host;
        this.databaseName = databaseName;
        this.dataSourcePool=new DataSourcePool(userName,passwored,host,databaseName);
    }

    public Connection getConnection() throws SQLException {

        return dataSourcePool.getConnections().getConnection();}
        @Override
        public Reports allStudentsInCourse () {
            return null;
        }

        @Override
        public Reports coursesOfStudent () {
            return null;
        }
    }
