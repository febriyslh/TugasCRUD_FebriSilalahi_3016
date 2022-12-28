/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package edu.praktikumpbo.crudmahasiswasederhana.db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Febri S
 * 21103016
 * SI05A
 */
public class ConectionHelper {

    public static Connection connect;
    public static Statement st;
    public static ResultSet rs;

    public static Connection getConnection() throws SQLException {
        String db = "sisteminformasi";
        String url = "jdbc:mysql://localhost:3306/" + db;
        String username = "root";
        String pass = "";

        if (connect == null) {
            try {
                System.out.println("Membuat koneksi...");
                Class.forName("com.mysql.cj.jdbc.Driver");
                connect = DriverManager.getConnection(
                        url,
                        username,
                        pass);
                st = (Statement) connect.createStatement();
                JOptionPane.showMessageDialog(null, "Terkoneksi");
                System.out.println("Koneksi berhasil.");
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Tidak Terkoneksi");
                System.out.println("Koneksi berhasil.");
            }
        }
        return connect;
    }

}
