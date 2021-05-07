/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import DAO.DAOGeneric;
import entities.Category;

/**
 *
 * @author bruno.silva
 */
public class Main {
    public static void main(String[] args) {
            Category category = new Category();
            DAOGeneric daoGeneric = new DAOGeneric(); 
            daoGeneric.create(category);
    }
}
