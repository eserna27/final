/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import views.events.indexEvents;
import views.events.newEvents;

/**
 *
 * @author BenitoH
 */
public class EventsController {
    public static void index(){
        indexEvents index = new indexEvents();
        index.setVisible(true);
    }
    
    public static void store(){
        newEvents event = new newEvents();
        event.setVisible(true);
    }
}
