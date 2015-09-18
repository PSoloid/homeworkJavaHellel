package com.Hellel.PSoloid.dao.connectionpool;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectPool extends ObjectPool<Connection> {

    public ConnectPool() {
        super();
        try {
            Class.forName("org.postgresql.Driver").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Connection create() {
        try {
            return (DriverManager.getConnection("jdbc:postgresql://localhost/test",
                    "postgres", "552230"));
        } catch (SQLException e) {
            e.printStackTrace();
            return (null);
        }
    }

    @Override
    public void expire(Connection o) {
        try {
            ((Connection) o).close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean validate(Connection o) {
        try {
            return (!((Connection) o).isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
}
