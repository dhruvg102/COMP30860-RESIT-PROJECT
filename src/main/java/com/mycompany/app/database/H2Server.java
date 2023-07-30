package com.mycompany.app.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class H2Server {

    

    public static void executeStmt(String statement) throws SQLException{
        Connection conn;
        Statement stmt;

        conn = DriverManager.getConnection("jdbc:h2:mem:tempdb");
        stmt = conn.createStatement();
    
        stmt.executeUpdate(statement);
       
        // stmt.close();
        // conn.close();
       
    }

    public static ResultSet executeQuery(String query) throws SQLException{
        Connection conn;
        Statement stmt;

        conn = DriverManager.getConnection("jdbc:h2:mem:tempdb");
        stmt = conn.createStatement();
    
        ResultSet rs = stmt.executeQuery(query);

        // stmt.close();
        // conn.close();
       
        return rs;
        
    }
    
}
