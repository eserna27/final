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
        ArrayList <Product> products = new ArrayList<Product>();
        products.add(new Product(1, "Elote", (float) 25.0, 25));
        return products;
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
