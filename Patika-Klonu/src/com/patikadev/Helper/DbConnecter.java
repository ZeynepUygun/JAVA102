package com.patikadev.Helper;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DbConnecter {

    private Connection connect = null;

    public Connection connectDB() {

        try {

            this.connect = DriverManager.getConnection(Config.DB_URL, Config.DB_USERNAME,
                Config.DB_PASSWORD);



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return this.connect;
    }

    public static Connection getInstance(){
        DbConnecter db =new DbConnecter();
        return db.connectDB();
    }


}
