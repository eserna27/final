/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Product;
import views.products.indexProducts;
import views.products.newProducts;

/**
 *
 * @author BenitoH
 */
public class ProductsController {
    public static void index(){
        indexProducts index = new indexProducts();
        index.fillTable(generateModelTable());
        index.setVisible(true);
    }
    
    public static void store(){
        newProducts product = new newProducts();
        product.setVisible(true);
    }
    
    public static void create(String [] params){
        if(paramsValidation(params)){
            Product.create(new Product(params[0], Float.parseFloat(params[1]), Integer.parseInt(params[2])));
            index();
        }else{
            newProducts product = new newProducts();
            product.setVisible(true);
            product.showErrors(params[0].isEmpty(), params[1].isEmpty(), params[2].isEmpty());
            product.setValues(params[0], params[1], params[2]);
        }
    }
    
    private static boolean paramsValidation(String [] params){
        boolean valid = !params[0].isEmpty() && !params[1].isEmpty() && !params[2].isEmpty();
        return valid;
    }
    
    private static DefaultTableModel generateModelTable(){
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Id", "Nombre", "Precio", "Minimo"});
        ArrayList <Product> products = Product.all();
        for(Product product : products){
            model.addRow(new Object[]{product.id(), product.name(), product.cost(), product.minimum()});
        }
        return model;
    }
}
