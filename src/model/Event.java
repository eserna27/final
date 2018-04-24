/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.ConnectionDB;
import model.Client;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BenitoH"Id", "Cliente", "Lugar", "Dia", "Hora", "Cotización"
 */
public class Event {
    private int id;
    private Client client;
    private int client_id;
    private String place;
    private String date;
    private String time;
    private Quotation quotation;
    
    public Event(int id, Client client, String place, Date date, Time time, Quotation quotation){
        this.id = id;
        this.client = client;
        this.place = place;
        this.date = date.toString();
        this.time = time.toString();
        this.quotation = quotation;
    }
    
    public Event(int id, int client_id, String place, String datetime){
        this.id = id;
        this.client = Client.find(client_id);
        this.place = place;
        this.date = datetime.split(" ")[0];
        this.time = datetime.split(" ")[1];
        this.quotation = Quotation.find(id);
    }
    
     public Event(int client_id, String place, String date, String time){
        this.client_id = client_id;
        this.place = place;
        this.date = date.toString();
        this.time = time.toString();
    }
    
    public static Event find(int id){
        ResultSet result = ConnectionDB.getData("SELECT * FROM EVENTS WHERE ID = '"+id+"' ");
        Event event = null;
        try {
            while(result.next()){
                event = new Event(
                    result.getInt("id"), 
                    result.getInt("client_id"), 
                    result.getString("place"), 
                    result.getString("datetime"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return event;
    }
    
    public static ArrayList all(){
        createTableSql();
       ArrayList <Event> events = new ArrayList<>();
        ResultSet result = ConnectionDB.getData("SELECT * FROM EVENTS;");    
        try {
            while(result.next()){
                Event event = new Event(
                        result.getInt("id"), 
                        result.getInt("client_id"), 
                        result.getString("place"), 
                        result.getString("datetime"));
                events.add(event);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return events;
    }
    
    public static void createTableSql(){
        Client.createTableSql();
         String sql = "CREATE TABLE IF NOT EXISTS EVENTS " +
                        "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                        " PLACE           TEXT    NOT NULL, " + 
                        " DATETIME      DATETIME      NOT NULL, " + 
                        " client_id INTEGER, " +
                        " FOREIGN KEY(client_id) REFERENCES CLIENTS(id)); ";
        ConnectionDB.sendData(sql);
    }
    
    public static void create(Event event){
        createTableSql();
        String sql = "INSERT INTO EVENTS (PLACE,DATETIME,CLIENT_ID) " +
                        "VALUES ('"+event.place()+"','"+ event.datetime()+"','"+event.clientID()+"');";

        ConnectionDB.sendData(sql);
    }
    
    public int id(){
        return id;
    }
    
    public String clientName(){
        return client.name();
    }
    
    public int clientID(){
        return client_id;
    }
    
    public String datetime(){
        return date+" "+time+":00";
    }
    
    public String place(){
        return place;
    }
    
    public String date(){
        return date;
    }
    
    public String time(){
        return time;
    }
    
    public Quotation quotation(){
        return quotation;
    }
    
    public boolean hasQuotation(){
        return quotation != null;
    }
}
