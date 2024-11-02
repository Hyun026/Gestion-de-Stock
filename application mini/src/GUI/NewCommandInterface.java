package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Conn.Constants;

import static stock.LaConn.*;

public class NewCommandInterface extends Frame {

    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTable clientTable;
    private JTable productTable;
    private DefaultTableModel clientTableModel;
    private DefaultTableModel productTableModel;
    private JTextField clientIdField = new JTextField();
    private JTextField productIdField = new JTextField();
    private JTextField quantityField = new JTextField();
    private commande commande;

    public NewCommandInterface(commande commande) {
        super("NewCommande");
        this.commande = commande;
       
        setResizable(false);
        // Initialize components
        jButton1 = new JButton();
        jButton2 = new JButton();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jPanel1 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jScrollPane2 = new JScrollPane();
        this.commande = commande;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel for client tableDASD
        clientTableModel = new DefaultTableModel(new String[]{"ID", "Name"}, 0);
        clientTable = new JTable(clientTableModel);
        JScrollPane clientScrollPane = new JScrollPane(clientTable);

        // panel for Produit table
        productTableModel = new DefaultTableModel(new String[]{"ID", "Name"}, 0);
        productTable = new JTable(productTableModel);
        JScrollPane productScrollPane = new JScrollPane(productTable);

        //BUTTONS
        jButton1.setText("addCommande");
        jButton1.setFont(new Font("Dialog", Font.BOLD, 18));
        jButton1.setBackground(Constants.SECONDARY_COLOR);
        jButton1.setForeground(Constants.TEXT_COLOR);
        

        jButton2.setText("Annuller");
        jButton2.setFont(new Font("Dialog", Font.BOLD, 15));
        jButton2.setBackground(Constants.SECONDARY_COLOR);
        jButton2.setForeground(Constants.TEXT_COLOR);


        jLabel1.setText("ID_CLIENT");
        jLabel1.setBounds(25, 150, 400, 20);
        jLabel1.setForeground(Constants.TEXT_COLOR);
        jLabel1.setFont(new Font("Dialog", Font.PLAIN, 15));

        clientIdField.setBounds(30, 185, 450, 30);
        clientIdField.setBackground(Constants.SECONDARY_COLOR);
        clientIdField.setForeground(Constants.TEXT_COLOR);
        clientIdField.setFont(new Font("Dialog", Font.PLAIN, 24));

        jLabel2.setText("ID_PRODUIT");
        jLabel2.setBounds(25, 150, 400, 20);
        jLabel2.setForeground(Constants.TEXT_COLOR);
        jLabel2.setFont(new Font("Dialog", Font.PLAIN, 15));

        productIdField.setBounds(30, 185, 450, 30);
        productIdField.setBackground(Constants.SECONDARY_COLOR);
        productIdField.setForeground(Constants.TEXT_COLOR);
        productIdField.setFont(new Font("Dialog", Font.PLAIN, 24));

        jLabel3.setText("QUANTITE");
        jLabel3.setBounds(15, 150, 400, 20);
        jLabel3.setForeground(Constants.TEXT_COLOR);
        jLabel3.setFont(new Font("Dialog", Font.PLAIN, 15));

        quantityField.setBounds(30, 185, 450, 30);
        quantityField.setBackground(Constants.SECONDARY_COLOR);
        quantityField.setForeground(Constants.TEXT_COLOR);
        quantityField.setFont(new Font("Dialog", Font.PLAIN, 24));

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertNewCommand();
            }
        });
        jButton1.setFont(new Font("Dialog", Font.BOLD, 18));
        jButton1.setBackground(Constants.SECONDARY_COLOR);
        jButton1.setForeground(Constants.TEXT_COLOR);

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // Close the current window
                dispose();

                // Show the commande interface
                commande.setVisible(true);
            }

        });
        jButton2.setFont(new Font("Dialog", Font.BOLD, 15));
        jButton2.setBackground(Constants.SECONDARY_COLOR);
        jButton2.setForeground(Constants.TEXT_COLOR);

        //layout
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(clientScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(32, 32, 32)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(clientIdField)
                                        .addComponent(productIdField)
                                        .addComponent(quantityField, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                                .addGap(88, 88, 88))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(productScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(97, 97, 97)
                                .addComponent(jButton1)
                                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(clientScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(81, 81, 81)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(clientIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1))
                                                .addGap(47, 47, 47)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(productIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3))))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                                .addComponent(productScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(15, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(133, 133, 133)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButton1)
                                                        .addComponent(jButton2))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
        fetchClients();
        fetchProducts();
        setVisible(true);

    }

    private void fetchClients() {
        try {
            Connection conn = DriverManager.getConnection(HOST, USER, PASSWORD);

            String query = "SELECT ID_CLIENT, NOM_CLIENT FROM CLIENT";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int clientId = rs.getInt("ID_CLIENT");
                String clientName = rs.getString("NOM_CLIENT");
                clientTableModel.addRow(new Object[]{clientId, clientName});
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error fetching clients: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void fetchProducts() {
        try {
            Connection conn = DriverManager.getConnection(HOST, USER, PASSWORD);

            String query = "SELECT ID_PRODUIT, NOM_PRODUIT FROM PRODUIT";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int productId = rs.getInt("ID_PRODUIT");
                String productName = rs.getString("NOM_PRODUIT");
                productTableModel.addRow(new Object[]{productId, productName});
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error fetching products: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void insertNewCommand() {
        try {
            int clientId = Integer.parseInt(clientIdField.getText());
            int productId = Integer.parseInt(productIdField.getText());
            int quantity = Integer.parseInt(quantityField.getText());

            Connection conn = DriverManager.getConnection(HOST, USER, PASSWORD);

            String insertQuery = "INSERT INTO COMMANDE (ID_CLIENT, ID_PRODUIT, QUANTITE_DE_PRODUIT) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertQuery);
            pstmt.setInt(1, clientId);
            pstmt.setInt(2, productId);
            pstmt.setInt(3, quantity);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "New command inserted successfully.", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                commande.updateCommands(); // Update the table in commande
                dispose(); // Close the window after successful insertion
            } else {
                JOptionPane.showMessageDialog(this, "Failed to insert new command.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

            pstmt.close();
            conn.close();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error inserting new command: " + ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

}
