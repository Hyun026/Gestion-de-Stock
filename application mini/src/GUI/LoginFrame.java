package GUI;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;

import static stock.LaConn.*;
import Conn.Constants;
import stock.User;

public class LoginFrame extends Frame{


    public LoginFrame(){
        super("Login");
        addCompenent();
    }

    public void addCompenent(){

        JLabel loginLabel = new JLabel("Login");

        loginLabel.setBounds(0, 25, 520, 100);

        loginLabel.setForeground(Constants.TEXT_COLOR);

        loginLabel.setFont(new Font("Dialog", Font.BOLD, 40));

        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(loginLabel);

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
        passwordLabel.setBounds(30, 335, 400, 25);
        passwordLabel.setForeground(Constants.TEXT_COLOR);
        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(30, 365, 450, 55);
        passwordField.setBackground(Constants.SECONDARY_COLOR);
        passwordField.setForeground(Constants.TEXT_COLOR);
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(passwordLabel);
        add(passwordField);


        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Dialog", Font.BOLD, 18));

        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginButton.setBackground(Constants.TEXT_COLOR);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                

                Connection conn = getConnection();

                String username = usernameField.getText();

                String password = new String(passwordField.getPassword());

                try {
                    if(User.authenticateUser(conn ,username, password)){

                        LoginFrame.this.dispose();

                        new MenuFrame().setVisible(true);

                        JOptionPane.showMessageDialog(LoginFrame.this,
                                "Login Successful!");
                        
                    }else{

                        JOptionPane.showMessageDialog(LoginFrame.this,
                                "Login Failed...");
                    }
                } catch (HeadlessException | SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });


        loginButton.setBounds(125, 520, 250, 50);
        add(loginButton);
        JLabel registerLabel = new JLabel("Not a user? Register Here");
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerLabel.setForeground(Constants.TEXT_COLOR);
        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LoginFrame.this.dispose();

                new RegisterFrame().setVisible(true);
            }
        });
        registerLabel.setBounds(125, 600, 250, 30);
        add(registerLabel);
    }

    
}
