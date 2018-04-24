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
    
    private static DefaultTableModel generateModelTable(){
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Id", "Nombre", "Precio", "Minimo"});
        ArrayList <Product> products = Product.all();
        System.out.println(products);
        for(Product product : products){
            model.addRow(new Object[]{product.id(), product.name(), product.cost(), product.minimum()});
        }
        return model;
    }
}
