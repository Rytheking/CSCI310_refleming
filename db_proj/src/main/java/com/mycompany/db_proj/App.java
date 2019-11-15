/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.db_proj;

import java.sql.*;


/**
 *
 * @author Ryan Fleming
 */
public class App{
    private static String url = "jdbc:sqlite:/Users/ryanfleming/illicit_substances.db"; 
    
    
    private Connection connect() {
        
        Connection cnct = null;
            try {
                cnct = DriverManager.getConnection(url);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        return cnct;
    }
    
    public static void createDatabase() {
 
        try (Connection cnct = DriverManager.getConnection(url)) {
            if (cnct != null) {
                DatabaseMetaData meta = cnct.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void createNewTable() {
        // SQLite connection string
        
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS substances (\n"
                + "    id integer PRIMARY KEY,\n"
                + "    substance text NOT NULL,\n"
                + "    schedule integer\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void insert(String substance, int schedule) {
        String sql = "INSERT INTO illict_substances(name,capacity) VALUES(?,?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, substance);
            pstmt.setDouble(2, schedule);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void update(int id, String substance, int schedule) {
        String sql = "UPDATE illict_substances SET name = ? , "
                + "capacity = ? "
                + "WHERE id = ?";
 
        try (Connection cnct = this.connect();
                PreparedStatement pstmt = cnct.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setString(1, substance);
            pstmt.setDouble(2, schedule);
            pstmt.setInt(3, id);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        new App().run();
    }

    void run() {
        createDatabase();
        createNewTable();
        insert("Raw Materials", 3000);
        insert("Semifinished Goods", 4000);
        insert("Finished Goods", 5000);
    }
}
