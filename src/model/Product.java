/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BenitoH
 */
public class Product {
    private int id;
    private String name;
    private float cost;
    private int minimum;
    
    public Product(String name, float cost, int minimum){
        this.name = name;
        this.cost = cost;
        this.minimum = minimum;
    }
    
    public Product(int id, String name, float cost, int minimum){
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.minimum = minimum;
    }
    
    public static ArrayList all(){
        createTableSql();
        ArrayList <Product> products = new ArrayList<Product>();
        ResultSet result = ConnectionDB.getData("SELECT * FROM PRODUCTS");
        try {
            while(result.next()){
                Product product = new Product(
                        result.getInt("id"), 
                        result.getString("name"), 
                        result.getFloat("cost"), 
                        result.getInt("minimum"));
                products.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }
    
    public static void createTableSql(){
         String sql = "CREATE TABLE IF NOT EXISTS PRODUCTS " +
                        "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                        " NAME           TEXT    NOT NULL, " + 
                        " COST      FLOAT     NOT NULL, " + 
                        " MINIMUM        TEXT) ";
        ConnectionDB.sendData(sql);
    }
    
    public static void create(Product product){
        createTableSql();
        String sql = "INSERT INTO PRODUCTS (NAME,COST,MINIMUM) " +
                        "VALUES ('"+product.name()+"','"+ product.cost()+"','"+product.minimum()+"');";

        ConnectionDB.sendData(sql);
    }
    
    public int id(){
        return id;
    }
    
    public String name(){
        return name;
    }
    
    public float cost(){
        return cost;
    }
    
    public int minimum(){
        return minimum;
    }
}
