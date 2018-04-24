/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

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
    
    public static boolean create(String name, String cellphone, String company){
        return true;
    }
    
    public static ArrayList all(){
        ArrayList <Client> clients = new ArrayList<Client>();
        clients.add(new Client(1, "Emmanuel", "8180202991", "JazzControls"));
        return clients;
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
