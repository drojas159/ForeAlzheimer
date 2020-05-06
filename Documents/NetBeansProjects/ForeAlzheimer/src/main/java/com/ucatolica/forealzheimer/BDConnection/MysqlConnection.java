/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucatolica.forealzheimer.BDConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Daniela
 */
public class MysqlConnection {

    private Connection con;

    public MysqlConnection() {
        this.con = null;
    }

    public Connection initializeDatabase() {
        try {
            String sURL = "jdbc:mysql://localhost:3306/arcadb?serverTimezone=" +TimeZone.getDefault().getID();
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    sURL, "root", "root");
//here sonoo is database name, root is username and password  
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

        return con;
    }

    public Connection getConnection() {
        return this.con;
    }
}

