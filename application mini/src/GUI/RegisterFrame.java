package GUI;

import java.awt.*;
import javax.swing.*;


import Conn.Constants;
import stock.User;
import static stock.LaConn.*;

import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RegisterFrame extends Frame {


    public RegisterFrame() {
        super("Register");
        addComponents();
    }

    private void addComponents(){

        JLabel registerLabel = new JLabel("Register");

        registerLabel.setBounds(0, 25, 520, 100);

        registerLabel.setForeground(Constants.TEXT_COLOR);

        registerLabel.setFont(new Font("Dialog", Font.BOLD, 40));
        
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(registerLabel);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(30, 150, 400, 25);
        usernameLabel.setForeground(Constants.TEXT_COLOR);
        usernameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        JTextField usernameField = new JTextField();
        usernameField.setBounds(30, 185, 450, 55);
        usernameField.setBackground(Constants.SECONDARY_COLOR);
        usernameField.setForeground(Constants.TEXT_COLOR);
        usernameField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(usernameLabel);
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30, 255, 400, 25);
        passwordLabel.setForeground(Constants.TEXT_COLOR);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(30, 285, 450, 55);
        passwordField.setBackground(Constants.SECONDARY_COLOR);
        passwordField.setForeground(Constants.TEXT_COLOR);
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(passwordLabel);
        add(passwordField);


        JButton registerButton = new JButton("Register");
        registerButton.setFont(new Font("Dialog", Font.BOLD, 18));

        registerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerButton.setBackground(Constants.TEXT_COLOR);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Connection conn = null;

                conn = getConnection();

                String username = usernameField.getText();

                String password = new String(passwordField.getPassword());

                try {
                    if(User.addUser(conn , username, password)){
                        RegisterFrame.this.dispose();

                        LoginFrame LoginFrame = new LoginFrame();
                        LoginFrame.setVisible(true);

                        JOptionPane.showMessageDialog(LoginFrame,
                                "Registered Account Successfully!");
                    }else{
                        JOptionPane.showMessageDialog(RegisterFrame.this,
                                "Error: Username already taken");

                        }
                } catch (HeadlessException | SQLException e1) {
                    e1.printStackTrace();
                }
                }    
        });
        registerButton.setBounds(125, 520, 250, 50);
        add(registerButton);

        JLabel loginLabel = new JLabel("Have an account? Login Here");
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginLabel.setForeground(Constants.TEXT_COLOR);
        loginLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RegisterFrame.this.dispose();

                new LoginFrame().setVisible(true);
            }
        });
        loginLabel.setBounds(125, 600, 250, 30);
        add(loginLabel);

    
}
}
