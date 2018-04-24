/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.Client;
import model.Event;
import views.events.indexEvents;
import views.events.newEvents;
import views.events.showEvents;

/**
 *
 * @author BenitoH
 */
public class EventsController {
    public static void index(){
        indexEvents index = new indexEvents();
        index.fillTable(generateModelTable());
        index.setVisible(true);
    }
    
    public static void store(){
        newEvents event = new newEvents();
        event.fillClientsOptions(Client.all());
        event.setVisible(true);
    }
    
    public static void show(int id){
        Event event = Event.find(id);
        showEvents show = new showEvents();
        show.setValues(event);
        show.setVisible(true);
    }
    
    private static DefaultTableModel generateModelTable(){
        try {
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new Object[]{"Id", "Cliente", "Lugar", "Dia", "Hora", "Cotización"});
            ArrayList <Event> events = Event.all();
            for(Event event : events){
                model.addRow(new Object[]{event.id(), event.clientName(), event.place(), event.date(), event.time(), event.quotation()});
            }
            return model;
        } catch (ParseException ex) {
            Logger.getLogger(EventsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
