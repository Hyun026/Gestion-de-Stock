
package GUI;
import static stock.Products.* ;
import static stock.LaConn.*;
import Conn.Constants;

import java.awt.*;
import javax.swing.*;
/**
 *
 * @author AzComputer
 */
public class ProduitAdd extends Frame {

    public ProduitAdd() {
        super("ADD PRODUCTS");
        initComponents();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        nom = new javax.swing.JTextField();
        Date = new javax.swing.JTextField();
        prix = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText(" NOM_PRODUIT:");
        jLabel2.setBounds(25, 150, 400, 25);
        jLabel2.setForeground(Constants.TEXT_COLOR);
        jLabel2.setFont(new Font("Dialog", Font.PLAIN, 15));

        nom.setBounds(30, 185, 450, 30);
        nom.setBackground(Constants.SECONDARY_COLOR);
        nom.setForeground(Constants.TEXT_COLOR);
        nom.setFont(new Font("Dialog", Font.PLAIN, 24));

        jLabel3.setText("date_dajoute :");
        jLabel3.setBounds(15, 150, 400, 25);
        jLabel3.setForeground(Constants.TEXT_COLOR);
        jLabel3.setFont(new Font("Dialog", Font.PLAIN, 15));

        
        Date.setBounds(30, 185, 450, 30);
        Date.setBackground(Constants.SECONDARY_COLOR);
        Date.setForeground(Constants.TEXT_COLOR);
        Date.setFont(new Font("Dialog", Font.PLAIN, 24));

        jLabel4.setText("PRIX :");
        jLabel4.setBounds(25, 150, 350, 25);
        jLabel4.setForeground(Constants.TEXT_COLOR);
        jLabel4.setFont(new Font("Dialog", Font.PLAIN, 15));

        prix.setBounds(30, 185, 450, 30);
        prix.setBackground(Constants.SECONDARY_COLOR);
        prix.setForeground(Constants.TEXT_COLOR);
        prix.setFont(new Font("Dialog", Font.PLAIN, 24));

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

        nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nom)
                    .addComponent(Date)
                    .addComponent(prix, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(160, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(37, 37, 37)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(prix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }

    private void nomActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
  
     String pname = nom.getText();
     String pPrix = prix.getText();
     AddToPRODUIT(getConnection(),pname,pPrix);
     
     
     Produit produit = new Produit();
        produit.show();

        dispose();  
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
          Produit produit = new Produit();
        produit.show();

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
            java.util.logging.Logger.getLogger(ProduitAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProduitAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProduitAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProduitAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProduitAdd().setVisible(true);
            }
        });
}
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Date;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField prix;
    // End of variables declaration//GEN-END:variables
}
