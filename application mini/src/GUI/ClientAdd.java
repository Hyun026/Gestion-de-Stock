
package GUI;

import static GUI.Clients.CreateClient;
import static stock.LaConn.getConnection;

import java.awt.*;
import javax.swing.*;

import Conn.Constants;

/**
 *
 * @author AzComputer
 */
public class ClientAdd extends Frame {

    public ClientAdd() {
        super("ADD Client");
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nom = new javax.swing.JTextField();
        adresse = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        contact = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("nom");
        jLabel2.setBounds(25, 150, 400, 25);
        jLabel2.setForeground(Constants.TEXT_COLOR);
        jLabel2.setFont(new Font("Dialog", Font.PLAIN, 15));

        nom.setBounds(30, 185, 450, 30);
        nom.setBackground(Constants.SECONDARY_COLOR);
        nom.setForeground(Constants.TEXT_COLOR);
        nom.setFont(new Font("Dialog", Font.PLAIN, 24));

        jLabel2.setText("adresse");
        jLabel2.setBounds(25, 150, 400, 25);
        jLabel2.setForeground(Constants.TEXT_COLOR);
        jLabel2.setFont(new Font("Dialog", Font.PLAIN, 15));

        adresse.setBounds(30, 185, 450, 30);
        adresse.setBackground(Constants.SECONDARY_COLOR);
        adresse.setForeground(Constants.TEXT_COLOR);
        adresse.setFont(new Font("Dialog", Font.PLAIN, 24));

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setFont(new Font("Dialog", Font.BOLD, 18));
        jButton1.setBackground(Constants.SECONDARY_COLOR);
        jButton1.setForeground(Constants.TEXT_COLOR);

        jButton2.setText("Annuler");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setFont(new Font("Dialog", Font.BOLD, 15));
        jButton2.setBackground(Constants.SECONDARY_COLOR);
        jButton2.setForeground(Constants.TEXT_COLOR);

        jLabel3.setText("contact");
        jLabel3.setText("date_dajoute :");
        jLabel3.setBounds(15, 150, 400, 25);
        jLabel3.setForeground(Constants.TEXT_COLOR);
        jLabel3.setFont(new Font("Dialog", Font.PLAIN, 15));

        contact.setBounds(30, 185, 450, 30);
        contact.setBackground(Constants.SECONDARY_COLOR);
        contact.setForeground(Constants.TEXT_COLOR);
        contact.setFont(new Font("Dialog", Font.PLAIN, 24));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(400, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(125, 125, 125)
                .addComponent(jButton1)
                .addGap(93, 93, 93))
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nom, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addComponent(adresse)
                    .addComponent(contact))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(adresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(58, 58, 58))
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
       
            String cname = nom.getText();
     String cAdresse = adresse.getText();
     String cContact = contact.getText();
     
     CreateClient(getConnection(),cname,cAdresse,cContact);
        
        Client client = new Client();
        client.show();

        dispose();  
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
             
        Client client = new Client();
        client.show();

        dispose();  
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
            java.util.logging.Logger.getLogger(ClientAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientAdd().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JTextField adresse;
    private javax.swing.JTextField contact;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nom;
    // End of variables declaration
}
