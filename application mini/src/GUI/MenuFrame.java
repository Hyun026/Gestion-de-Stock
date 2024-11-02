package GUI;

import java.awt.*;
import javax.swing.*;
import Conn.Constants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends Frame {

    public MenuFrame(){
        super("Menu");
        addComponents();
    }
    
    public void  addComponents(){


        JLabel menuLabel = new JLabel("Menu");

        menuLabel.setBounds(0, 25, 520, 100);

        menuLabel.setForeground(Constants.TEXT_COLOR);

        menuLabel.setFont(new Font("Dialog", Font.BOLD, 40));

        menuLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(menuLabel);

        JButton productButton = new JButton("Products");
        productButton.setFont(new Font("Dialog", Font.BOLD, 18));

        productButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        productButton.setBackground(Constants.TEXT_COLOR);
        productButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MenuFrame.this.dispose();

                new Produit().setVisible(true);
            }
        });
        productButton.setBounds(115, 150, 300, 50);
        add(productButton);

        JButton CommandeButton = new JButton("Commander");
        CommandeButton.setFont(new Font("Dialog", Font.BOLD, 18));

        CommandeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        CommandeButton.setBackground(Constants.TEXT_COLOR);
        CommandeButton.setBounds(115, 250, 300, 50);
        add(CommandeButton);
        
        CommandeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                commande commandeInterface = new commande();
                commandeInterface.setVisible(true);
            
            }
        });

        JButton ClientButton = new JButton("Clients");
        ClientButton.setFont(new Font("Dialog", Font.BOLD, 18));

        ClientButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ClientButton.setBackground(Constants.TEXT_COLOR);
        ClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MenuFrame.this.dispose();

                new Client().setVisible(true);
            }
        });
        ClientButton.setBounds(115, 350, 300, 50);
        add(ClientButton);

        JButton QuiteButton = new JButton("LogOut");
        QuiteButton.setFont(new Font("Dialog", Font.BOLD, 18));

        QuiteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        QuiteButton.setBackground(Constants.TEXT_COLOR);
        QuiteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MenuFrame.this.dispose();

                new LoginFrame().setVisible(true);
            }
        });
        QuiteButton.setBounds(115, 450, 300, 50);
        add(QuiteButton);
    }

}
