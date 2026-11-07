/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.risnomuffler.controller;

import com.risnomuffler.model.Product;
import com.risnomuffler.repository.ProductRepository;
import com.risnomuffler.view.CatalogView;
import java.util.List;
import javax.swing.JOptionPane;
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

    private void initController() {
        loadProducts();
        
        view.getBtnRefresh().addActionListener(e -> loadProducts());
        
        view.getBtnTambah().addActionListener(e -> {
            Product newProduct = view.showFormDialog(null);
            if (newProduct != null) {
                if (repository.saveProduct(newProduct)) {
                    JOptionPane.showMessageDialog(view, "Produk berhasil ditambahkan!");
                    loadProducts();
                } else {
                    JOptionPane.showMessageDialog(view, "Gagal menambahkan produk.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        view.getBtnEdit().addActionListener(e -> {
            int selectedRow = view.getTable().getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(view, "Pilih produk yang ingin diedit terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int id = (int) view.getTable().getValueAt(selectedRow, 0);
            String name = (String) view.getTable().getValueAt(selectedRow, 1);
            String type = (String) view.getTable().getValueAt(selectedRow, 2);
            double price = (double) view.getTable().getValueAt(selectedRow, 3);
            int stock = (int) view.getTable().getValueAt(selectedRow, 4);
            
            Product existingProduct = new Product(id, name, type, price, stock);
            Product updatedProduct = view.showFormDialog(existingProduct);
            
            if (updatedProduct != null) {
                if (repository.updateProduct(updatedProduct)) {
                    JOptionPane.showMessageDialog(view, "Produk berhasil diperbarui!");
                    loadProducts();
                } else {
                    JOptionPane.showMessageDialog(view, "Gagal memperbarui produk.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        view.getBtnHapus().addActionListener(e -> {
            int selectedRow = view.getTable().getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(view, "Pilih produk yang ingin dihapus terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int id = (int) view.getTable().getValueAt(selectedRow, 0);
            int confirm = JOptionPane.showConfirmDialog(view, "Yakin ingin menghapus produk ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                if (repository.deleteProduct(id)) {
                    JOptionPane.showMessageDialog(view, "Produk berhasil dihapus!");
                    loadProducts();
                } else {
                    JOptionPane.showMessageDialog(view, "Gagal menghapus produk.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void loadProducts() {
        List<Product> products = repository.getAllProducts();
        view.setProducts(products);
    }
}