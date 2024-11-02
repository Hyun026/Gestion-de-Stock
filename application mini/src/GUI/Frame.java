package GUI;

import javax.swing.*;

import Conn.Constants;


public class Frame extends JFrame {

    public Frame(String title){

         super(title);

         setSize(520, 680);
 
         setDefaultCloseOperation(EXIT_ON_CLOSE);
 
         setLayout(null);
 
         setLocationRelativeTo(null);
 
         setResizable(false);
 
         getContentPane().setBackground(Constants.PRIMARY_COLOR);


        
    }

    
}