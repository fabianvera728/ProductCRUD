package com.company.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionDatabase {

    Connection connection = null;

    public ConnectionDatabase()  {
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:src/database/crudproducto.db";
            connection = DriverManager.getConnection(url);
        }catch (ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
    }

    public Connection getConnection(){
        return connection;
    }


}
