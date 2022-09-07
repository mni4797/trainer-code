package com.revature.utils;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionUtil {

    private static Connection con;

    private ConnectionUtil(){
        con = null;
    }

    //This method will be designed to give me a connection object
    public static Connection getConnection(){

        //Determine if we already have an existing connection, if so just return that
        try {
            
            if (con != null && !con.isClosed()) {
                return con;
            }

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }

        String url, user, pass;

        Properties prop = new Properties();

        try {
            Class.forName("org.postgresql.Driver");
            
            //I've loaded the property file from my resource folder for my prop object to use
            //We have to change from a hard coded path of the database.properties into an included method called getResourceAsStream()
            //  to dynamically point to our resources folder and pick a file there
            prop.load(ConnectionUtil.class.getResourceAsStream("/database.properties"));

            url = prop.getProperty("url");
            user = prop.getProperty("user");
            pass = prop.getProperty("pass");

            con = DriverManager.getConnection(url, user, pass);

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        
        return con;
    }
}
