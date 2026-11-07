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
    private JButton btnRefresh, btnTambah, btnEdit, btnHapus;
    
    public CatalogView(){
        setTitle("Katalog knalpot Risno Muffler");
        setSize(800, 450);
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
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnRefresh = new JButton("Refresh");
        btnTambah = new JButton("Tambah Produk");
        btnEdit = new JButton("Edit Produk");
        btnHapus = new JButton("Hapus Produk");

        topPanel.add(new JLabel("Daftar Produk:"));
        topPanel.add(btnRefresh);
        topPanel.add(btnTambah);
        topPanel.add(btnEdit);
        topPanel.add(btnHapus);

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
    public JButton getBtnRefresh(){return btnRefresh; }
    public JButton getBtnTambah() { return btnTambah; }
    public JButton getBtnEdit() { return btnEdit; }
    public JButton getBtnHapus() { return btnHapus; }
    
    public JTable getTable() { return table; }
    
    public Product showFormDialog(Product existingProduct) {
        JTextField nameField = new JTextField(existingProduct != null ? existingProduct.getName() : "");
        JTextField typeField = new JTextField(existingProduct != null ? existingProduct.getType() : "");
        JTextField priceField = new JTextField(existingProduct != null ? String.valueOf(existingProduct.getPrice()) : "");
        JTextField stockField = new JTextField(existingProduct != null ? String.valueOf(existingProduct.getStock()) : "");

        Object[] message = {
            "Nama Produk:", nameField,
            "Tipe:", typeField,
            "Harga:", priceField,
            "Stok:", stockField
        };

        String title = existingProduct == null ? "Tambah Produk Baru" : "Edit Produk";
        int option = JOptionPane.showConfirmDialog(this, message, title, JOptionPane.OK_CANCEL_OPTION);
        
        if (option == JOptionPane.OK_OPTION) {
            try {
                String name = nameField.getText();
                String type = typeField.getText();
                double price = Double.parseDouble(priceField.getText());
                int stock = Integer.parseInt(stockField.getText());
                
                int id = existingProduct != null ? existingProduct.getId() : 0;
                return new Product(id, name, type, price, stock);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Harga dan Stok harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
    }
}
