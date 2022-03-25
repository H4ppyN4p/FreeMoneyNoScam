package com.example.freemoneynoscam.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;


public class DBServiceCode
{
    Connection connection;
    static Statement stmt;
    static ResultSet rs;
    static String sqlString;

    public DBServiceCode(){


        onRunConnectToDB();
    }

    static final String DB_URL = "jdbc:mysql://localhost:3306/free_money_no_scam";
    static final String USER = "root";
    static final String PASS = "PASSWORDDD";

    public void onRunConnectToDB(){

        try
        {
            connection = DriverManager.getConnection(DB_URL,USER,PASS);
        }
        catch(Exception e)
        {
            System.out.println("Shit pommes frit, min DB connection virker ikke!!!!!!!!!**************");
        }

        //
        //Display the URL and connection information
        System.out.println("URL: " + DB_URL);
        System.out.println("Vi har en connection. Jubiii!!!!!");
    }

    public void sendEmailToDB(String email){

        try {
        //Get another statement object initialized as shown.
        Statement statement = connection.createStatement();

        sqlString = "INSERT INTO emails" +
                "(email)" +
                "VALUES ('" + email + "')";
        stmt.executeUpdate(sqlString);
    }
        catch (Exception e)
    {
        System.out.println("Shit. Vores POST gik galt.");
        System.out.println(e);
    }
    }
}
