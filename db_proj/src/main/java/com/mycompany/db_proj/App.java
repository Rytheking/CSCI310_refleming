/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.db_proj;

import java.sql.*;
import java.util.Scanner;
import java.util.regex.*;

/**
 *
 * @author Ryan Fleming
 */
public class App{
    private static String url = "jdbc:sqlite:/Users/ryanfleming/Wendy's.db"; 
    
    
    private Connection connect() {
        
        Connection cnct = null;
            try {
                cnct = DriverManager.getConnection(url);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        return cnct;
    }
    
    

    void run() {
        connect();
    }
}
