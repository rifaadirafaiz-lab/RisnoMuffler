/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.risnomuffler.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Faiz <faiz@email.com>
 */
public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/risno_muffler?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD ="qwerty123";
    private static Connection connection = null;
    
    private DatabaseConnection(){}
    
    public static Connection getConnection() throws SQLException{
        if (connection == null || connection.isClosed()){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e){
                throw new SQLException("MySQL JDBC Driver tidak ditemukan.",e);
            }
        }
        return connection;
    }
}
