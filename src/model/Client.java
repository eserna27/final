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
public class Client {
    private int id;
    private String name;
    private String cellphone;
    private String company;
    
    public Client(String name, String cellphone, String company){
        this.name = name;
        this.cellphone = cellphone;
        this.company = company;
    }
    
    public Client(int id, String name, String cellphone, String company){
        this.id = id;
        this.name = name;
        this.cellphone = cellphone;
        this.company = company;
    }
    
    public static ArrayList all(){
        createTableSql();
        ArrayList <Client> clients = new ArrayList<Client>();
        ResultSet result = ConnectionDB.getData("SELECT * FROM CLIENTS");
        try {
            while(result.next()){
                Client client = new Client(
                        result.getInt("id"), 
                        result.getString("name"), 
                        result.getString("cellphone"), 
                        result.getString("company"));
                clients.add(client);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clients;
    }
    
    public static Client find(int id){
        ResultSet result = ConnectionDB.getData("SELECT * FROM CLIENTS WHERE ID = '"+id+"'");
        Client client = null;
        try {
            while(result.next()){
                client = new Client(
                    result.getInt("id"), 
                    result.getString("name"), 
                    result.getString("cellphone"), 
                    result.getString("company"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return client;
    }
    
    public static void createTableSql(){
         String sql = "CREATE TABLE IF NOT EXISTS CLIENTS " +
                        "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                        " NAME           TEXT    NOT NULL, " + 
                        " CELLPHONE      TEXT     NOT NULL, " + 
                        " COMPANY        TEXT) ";
        ConnectionDB.sendData(sql);
    }
    
    public static void create(Client client){
        createTableSql();
        String sql = "INSERT INTO CLIENTS (NAME,CELLPHONE,COMPANY) " +
                        "VALUES ('"+client.name()+"','"+ client.cellphone()+"','"+client.company()+"');";

        ConnectionDB.sendData(sql);
    }
    
    public int id(){
        return id;
    }
    
    public String name(){
        return name;
    }
    
    public String cellphone(){
        return cellphone;
    }
    
    public String company(){
        return company;
    }
}
