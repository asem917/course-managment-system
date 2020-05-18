package model.dao.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class DataSourcePool {

    private Queue2 pool= Queue2.getInstance();

    private Connection connection;


    public DataSourcePool() {

    }

    public  WraperConnection getWraperConnections() throws SQLException {
        if (pool.isEmpty())
            return  new WraperConnection() ;
        else {
            WraperConnection temp = pool.deQueue();
            if (temp.getC().plusHours(6).compareTo(LocalDateTime.now()) >= 0)
                return temp;
            else
                temp.getConnection().close();
            return getWraperConnections();

        }
    }
    public void releasConnection(WraperConnection c){
        pool.enQueue(c);
    }
}




