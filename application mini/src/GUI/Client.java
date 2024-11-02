package GUI;

import Conn.Constants;
import java.awt.*;

import GUI.Clients;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author AzComputer
 */
public class Client extends Frame {
    public Client() {
        super("Client");
        initComponents();
        Object[] a = Clients.GetClient();
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("ID_CLIENT");
        model.addColumn("NOM_CLIENT");
        model.addColumn("date_dajoute");
        model.addColumn("ADRESSE_CLIENT");
        model.addColumn("CONTACT_CLIENT");
        for (Object row : a) {
            Object[] rowData = (Object[]) row;
            model.addRow(rowData);
           
        }
        jTable1.setModel(model);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
          
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "nom", "adresse", "date d'ajoute", "contact"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setOpaque(false);
        jTable1.setBackground(Constants.SECONDARY_COLOR);
        jScrollPane1.setViewportView(jTable1);

        jMenu1.setText("User");
        jMenuItem1.setText("Menu");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.setFont(new Font("Dialog", Font.BOLD, 12));
        jMenu1.setForeground(Constants.TEXT_COLOR);
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        jButton1.setText("add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setFont(new Font("Dialog", Font.BOLD, 18));
        jButton1.setBackground(Constants.SECONDARY_COLOR);
        jButton1.setForeground(Constants.TEXT_COLOR);

        jButton2.setText("delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setFont(new Font("Dialog", Font.BOLD, 15));
        jButton2.setBackground(Constants.SECONDARY_COLOR);
        jButton2.setForeground(Constants.TEXT_COLOR);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jButton2)
                        .addGap(181, 181, 181)
                        .addComponent(jButton1)))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        ClientAdd clientAdd = new ClientAdd();
        clientAdd.show();
    dispose();      
   }

   private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
    MenuFrame stock = new MenuFrame();
       stock.show();
   dispose(); 
   }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
           int selectedRowIndex = jTable1.getSelectedRow();
    System.out.println(selectedRowIndex);

    if (selectedRowIndex != -1) {
        int clientId = (int) jTable1.getValueAt(selectedRowIndex, 0);

        boolean deleted = Clients.deleteClient(clientId);

        if (deleted) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.removeRow(selectedRowIndex);
        } else {
            JOptionPane.showMessageDialog(null, "Failed to delete client.", "Deletion Failed", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Please select a row to delete.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
    }                                       

    }


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client().setVisible(true);
            }
        });
    }
    

    // Variables declaration 
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuBar jMenuBar1;
    

    // End of variables declaration//

   
}
