/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author BenitoH
 */
public class Client {
    private String name;
    private String cellphone;
    private String company;
    
    public Client(String name, String cellphone, String company){
        this.name = name;
        this.cellphone = cellphone;
        this.company = company;
    }
    
    public static boolean create(String name, String cellphone, String company){
        return true;
    }
}
