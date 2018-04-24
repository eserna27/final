/*o
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalmain;

import model.Client;
import model.Event;
import model.Product;
import model.Quotation;
import views.users.indexUsers;

/**
 *
 * @author BenitoH
 */
public class finalmain {
    public static void main(String[] args) {
        Client.createTableSql();
        Product.createTableSql();
        Event.createTableSql();
        Quotation.createTableSql();       
        indexUsers index = new indexUsers();
        index.setVisible(true);
    }
}
