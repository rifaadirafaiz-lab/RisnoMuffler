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
public class CatalogView extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton btnRefresh;
    
    public CatalogView(){
        setTitle("Katalog knalpot Risno Muffler");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        initComponents();
    }
    private void initComponents(){
        String[] columns = {"ID", "Nama Product", "Tipe", "Harga (Rp)", "Stok"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        btnRefresh = new JButton("Refresh Data");
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblJudul = new JLabel("Daftar Produk Knalpot:");
        lblJudul.setFont(new Font("Arial", Font.BOLD, 14));
        topPanel.add(lblJudul);
        topPanel.add(btnRefresh);
        
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    public void setProducts(List<Product>Products){
        tableModel.setRowCount(0);
        
        for(Product p : Products){
            Object[] row = {
                p.getId(),
                p.getName(),
                p.getType(),
                p.getPrice(),
                p.getStock()
            };
            tableModel.addRow(row);
        }
    }
    public JButton getBtnRefresh(){
        return btnRefresh;
    }
}
