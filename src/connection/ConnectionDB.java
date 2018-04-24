/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BenitoH
 */
public class ConnectionDB {
    String url = "granito.db";

    public Connection connect(){
        Connection connection = null;
        try {
           Class.forName("org.sqlite.JDBC");
           connection = DriverManager.getConnection("jdbc:sqlite:"+url);
        } catch ( Exception e ) {
           System.err.println( e.getClass().getName() + ": " + e.getMessage() );
           System.exit(0);
        }
        return connection;
    }
    
    public static void close(Connection connection){
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void sendData(String sqlStatment){
        try{
            Connection connection = new ConnectionDB().connect();
            Statement statement = connection.createStatement();
            statement.execute(sqlStatment);
            close(connection);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static ResultSet getData(String sqlStatment){
        ResultSet result = null;
        try{
            Connection connection = new ConnectionDB().connect();
            Statement statement = connection.createStatement();
            result = statement.executeQuery(sqlStatment);
            result.getArray(sqlStatment);
            close(connection);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
