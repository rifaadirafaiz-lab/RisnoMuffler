/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.risnomuffler.controller;

/**
 *
 * @author Faiz <faiz@email.com>
 */
public class CatalogController {
    private final CatalogView;
    private final ProductRepository repository;
    
    public CatalogController(CatalogView view, ProductRepository repository) {
        this.view = view;
        this.repository = repository;
        
    }
}
