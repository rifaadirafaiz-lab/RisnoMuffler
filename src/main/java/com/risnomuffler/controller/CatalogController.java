/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.risnomuffler.controller;

import com.risnomuffler.model.Product;
import com.risnomuffler.repository.ProductRepository;
import com.risnomuffler.view.CatalogView;
import java.util.List;
/**
 *
 * @author Faiz <faiz@email.com>
 */
public class CatalogController {
    private final CatalogView view;
    private final ProductRepository repository;
    
    public CatalogController(CatalogView view, ProductRepository repository) {
        this.view = view;
        this.repository = repository;
        initController();
    }
    
    private void initController(){
        loadProducts();
        
        view.getBtnRefresh().addActionListener(e -> loadProducts());
    }
    
    private void loadProducts(){
        List<Product> products = repository.getAllProducts();
        
        view.setProducts(products);
    }
}
