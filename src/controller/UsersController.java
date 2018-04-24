/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import views.users.indexUsers;

/**
 *
 * @author BenitoH
 */
public class UsersController {
    public static void index(){
        indexUsers index = new indexUsers();
        index.setVisible(true);
    }
}
