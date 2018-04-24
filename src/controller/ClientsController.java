/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Client;
import views.clients.indexClients;
import views.clients.newClients;

/**
 *
 * @author BenitoH
 */
public class ClientsController {
    public static void index(){
        indexClients index = new indexClients();
        index.fillTable(generateModelTable());
        index.setVisible(true);
    }
    
    public static void store(){
        newClients client = new newClients();
        client.setVisible(true);
    }
    
    public static void create(String [] params){
        if(paramsValidation(params)){
            Client.create(params[0], params[1], params[2]);
            index();
        }else{
            newClients client = new newClients();
            client.setVisible(true);
            client.showErrors(params[0].isEmpty(), params[1].isEmpty(), params[2].isEmpty());
            client.setValues(params[0], params[1], params[2]);
        }
    }
    
    private static boolean paramsValidation(String [] params){
        boolean valid = !params[0].isEmpty() && !params[1].isEmpty() && !params[2].isEmpty();
        return valid;
    }
    
    private static DefaultTableModel generateModelTable(){
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Id", "Nombre", "Celular", "Compañia"});
        ArrayList <Client> clients = Client.all();
        for(Client client : clients){
            model.addRow(new Object[]{client.id(), client.name(), client.cellphone(), client.company()});
        }
        return model;
    }
}
