/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.risnomuffler.main;

import com.risnomuffler.controller.CatalogController;
import com.risnomuffler.repository.ProductRepository;
import com.risnomuffler.repository.ProductRepositoryImpl;
import com.risnomuffler.view.CatalogView;
import javax.swing.SwingUtilities;
/**
 *
 * @author Faiz <faiz@email.com>
 */
public class main {
   public static void main(String[] args){
       SwingUtilities.invokeLater(()->{
           CatalogView view = new CatalogView();
           ProductRepository repository = new ProductRepositoryImpl();
           new CatalogController(view, repository);
           view.setVisible(true);
       }
       );
   } 
}
