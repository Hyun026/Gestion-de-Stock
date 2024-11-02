package GUI;
import static stock.LaConn.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Conn.Constants;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class commande extends Frame {
    private JTable table;
    private DefaultTableModel model;
    private JButton addButton;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuBar jMenuBar1;

/**
 *
 * @author AzComputer
 */
    public commande() {
       super("Commande");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 450);

        // Initialize the table with columns
        String[] columns = { "Command ID", "Client Name", "Product Name", "Quantity" };
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        table.setOpaque(false);
        table.setBackground(Constants.SECONDARY_COLOR);

        jMenu1.setText("User");
        jMenuItem1.setText("Menu");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.setFont(new Font("Dialog", Font.BOLD, 12));
        jMenu1.setForeground(Constants.TEXT_COLOR);
        jMenuBar1.add(jMenu1);

    
        setJMenuBar(jMenuBar1);

        JScrollPane scrollPane = new JScrollPane(table);

        // Initialize button
        addButton = new JButton("Add Command");
        addButton.setFont(new Font("Dialog", Font.BOLD, 18));
        addButton.setBackground(Constants.SECONDARY_COLOR);
        addButton.setForeground(Constants.TEXT_COLOR);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(225, 225, 225))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        pack();
        setLocationRelativeTo(null);
        fetchCommands();

        jMenuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                commande.this.dispose();

                // launch the register gui
                new MenuFrame().setVisible(true);
            }
        });

       
        addButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                
                NewCommandInterface newCommandInterface = new NewCommandInterface(commande.this);
                newCommandInterface.setVisible(true);
            

            }
        });

        setVisible(true);

    }

    private void fetchCommands() {
        try {
            Connection conn = DriverManager.getConnection(HOST, USER, PASSWORD);

            String query = "SELECT C.ID_COMMANDE, CL.NOM_CLIENT, P.NOM_PRODUIT, C.QUANTITE_DE_PRODUIT " +
                    "FROM COMMANDE C " +
                    "JOIN CLIENT CL ON C.ID_CLIENT = CL.ID_CLIENT " +
                    "JOIN PRODUIT P ON C.ID_PRODUIT = P.ID_PRODUIT";

            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int commandId = rs.getInt("ID_COMMANDE");
                String clientName = rs.getString("NOM_CLIENT");
                String productName = rs.getString("NOM_PRODUIT");
                int quantity = rs.getInt("QUANTITE_DE_PRODUIT");

                model.addRow(new Object[] { commandId, clientName, productName, quantity });
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error fetching commands: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
     public void updateCommands() {
        // Clear existing data
        model.setRowCount(0);

        // Fetch and display updated commands from the database
        fetchCommands();
    }

}