/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author LAB 2 PC 04
 */
public class koneksi {

    /**
     * @param args the command line arguments
     */
   
        // TODO code application logic here
    private static Connection con;
    public static Connection getcon(){
        if (con == null){
            try{
                String url = "jdbc:mysql://localhost/perpustakaan_nasional"; 
                String username = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e){
            System.out.println(e);
        }
    }
    return con;    
}
    }
    

