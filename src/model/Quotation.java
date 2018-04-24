/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static model.Product.createTableSql;

/**
 *
 * @author BenitoH
 */
public class Quotation {
    private int id;
    private int product_id;
    private String extras;
    private String delivery;
    private float total;
    private int event_id;
    
    public Quotation(int id, int product_id, String extras, String delivery, float total){
        this.id = id;
        this.product_id = product_id;
        this.extras = extras;
        this.delivery = delivery;
        this.total = total;
    }
    
    public Quotation(int product_id, String extras, String delivery, float total, int event_id){
        this.product_id = product_id;
        this.extras = extras;
        this.delivery = delivery;
        this.total = total;
        this.event_id = event_id;
    }
    
    public static void createTableSql(){
        String sql = "CREATE TABLE IF NOT EXISTS QUOTATIONS " +
                        "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                        " EXTRAS           TEXT    NOT NULL, " + 
                        " DELIVERY      TEXT      NOT NULL, " + 
                        " TOTAL        FLOAT," +
                        " event_id INTEGER,"+ 
                        " product_id INTEGER,"+
                        " FOREIGN KEY(event_id) REFERENCES EVENTS(id)," +
                        " FOREIGN KEY(product_id) REFERENCES PRODUCTS(id)); ";
        ConnectionDB.sendData(sql);
    }
    
     public static Quotation find(int id){
        ResultSet result = ConnectionDB.getData("SELECT * FROM QUOTATIONS WHERE EVENT_ID = '"+id+"'");
        Quotation quotation = null;
        try {
            while(result.next()){
                quotation = new Quotation(
                        result.getInt("id"),
                        result.getInt("product_id"),
                        result.getString("extras"),
                        result.getString("delivery"),
                        result.getFloat("total")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return quotation;
    }
     
     public static void create(Quotation quotation){
        createTableSql();
        String sql = "INSERT INTO QUOTATIONS (product_id,EXTRAS,DELIVERY,TOTAL, event_id) " +
                        "VALUES ('"+quotation.product_id+"','"+ quotation.extras+"','"+ quotation.delivery+"','"+quotation.total+"','"+quotation.event_id+"');";

        ConnectionDB.sendData(sql);
    }
     
    public int eventId(){
        return event_id;
    }
    
    public int id(){
        return id;
    }
}
