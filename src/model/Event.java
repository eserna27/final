/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Time;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author BenitoH"Id", "Cliente", "Lugar", "Dia", "Hora", "Cotización"
 */
public class Event {
    private int id;
    private Client client;
    private String place;
    private String date;
    private String time;
    private boolean quotation;
    
    public Event(int id, Client client, String place, String date, String time, boolean quotation){
        this.id = id;
        this.client = client;
        this.place = place;
        this.date = date;
        this.time = time;
        this.quotation = quotation;
    }
    
    public static ArrayList all() throws ParseException{
        ArrayList <Event> events = new ArrayList<>();
        events.add(new Event(1, new Client(1, "Emmanuel", "8180202991", "JazzControls"), "San nicolas", "20/03/2018", "20:10", false));
        return events;
    }
    
    public static Event find(int id){
        Event event = new Event(id, new Client(1, "Emmanuel", "8180202991", "JazzControls"), "San nicolas", "20/03/2018", "20:10", true);
        return event;
    }
    
    public static void create(String clientId, String place, String date, String time){
        
    }
    
    public int id(){
        return id;
    }
    
    public String clientName(){
        return client.name();
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
    
    public boolean quotation(){
        return quotation;
    }
}
