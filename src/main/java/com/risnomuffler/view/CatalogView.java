/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.risnomuffler.view;
import com.risnomuffler.model.Product;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 *
 * @author Faiz <faiz@email.com>
 */
public class CatalogView {
    private JTable table;
    private DefaultTableModel teblemodel;
    private JButton btnRefresh;
    
    public CatalogView(){
        setTitle("Katalog knalpot Risno Muffler");
        setSize(700, 400);
        setDefaultCloseOperation(Jframe.EXIT_ON_CLOSE);
        setLocationRevelationTo(null);
        setLayout(new BorderLayout());
        
        initComponents();
    }
    private void initComponents(){
        String[] columns = {"ID", "Nama Product", "Tipe", "Harga (Rp)", "Stok"};
        tableModel = new DefaulTableModel(columns, 0) {
            
        }
    }
}
