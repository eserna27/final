/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import views.products.indexProducts;
import views.products.newProducts;

/**
 *
 * @author BenitoH
 */
public class ProductsController {
    public static void index(){
        indexProducts index = new indexProducts();
        index.setVisible(true);
    }
    
    public static void store(){
        newProducts product = new newProducts();
        product.setVisible(true);
    }
}
