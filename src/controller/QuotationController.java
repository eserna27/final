package controller;

import static controller.EventsController.index;
import model.Product;
import model.Quotation;
import views.quotations.newQuotations;
import views.quotations.showQuotations;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BenitoH
 */
public class QuotationController {

    public static void store(int eventId) {
       newQuotations quotation = new newQuotations();
       quotation.setEventID(eventId);
       quotation.fillProductsOptions(Product.all());
       quotation.setVisible(true);
    }
    
    public static void create(String [] params, int eventId){
        Quotation.create(new Quotation(Integer.parseInt(params[0]), params[1], params[2], Float.parseFloat(params[3]), eventId));
        EventsController.show(eventId);
    }
    
    public static void show(int eventId){
        showQuotations show = new showQuotations();
        show.setValues(Quotation.find(eventId));
        show.setVisible(true);
    }
}