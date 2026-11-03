/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.risnomuffler.repository;
import com.risnomuffler.model.Product;
import java.util.List;
/**
 *
 * @author Faiz <faiz@email.com>
 */
public interface ProductRepository {
    List<Product> getAllProducts();
}
