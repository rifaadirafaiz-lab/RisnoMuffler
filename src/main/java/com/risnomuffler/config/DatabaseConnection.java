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
    private static final String PASSWORD = "qwerty123"; // <--- Pastikan ini benar!

    public static Connection getConnection() throws SQLException {
        try {
            // Tambahkan baris ini agar driver dikenali
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Kembalikan koneksi
            return DriverManager.getConnection(URL, USER, PASSWORD);
            
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR: Driver MySQL tidak ditemukan!");
            throw new SQLException("Driver tidak ditemukan", e);
        } catch (SQLException e) {
            System.err.println("ERROR KONEKSI: " + e.getMessage());
            throw e; // Lemparkan error agar bisa ditangkap oleh Repository
        }
    }
}
