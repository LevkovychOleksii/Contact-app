package com.testlesson.contactbook.swing;

import com.testlesson.contactbook.Entity.Contact;
import com.testlesson.contactbook.JDBC.DBConnection;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DeleteFrame extends JFrame {
    private Contact contact;
    private JLabel label;
    private JTextField fieldName;
    private JTextField phoneNumber;
    private JTextField informationLabel;
    private JButton deleteButton;
    private JPanel panel1;
    private JPanel panel2;
    private DBConnection dbConnection;
    public DeleteFrame(){
        dbConnection = new DBConnection();
        label = new JLabel("To delete contact write the name");
        label.setFont(new Font("MV Boli", Font.PLAIN, 30));

        fieldName = new JTextField("Name");
        fieldName.setPreferredSize(new Dimension(200, 30));

        informationLabel = new JTextField("");
        informationLabel.setPreferredSize(new Dimension(250, 30));
        informationLabel.setBackground(Color.YELLOW);

        informationLabel.setBorder(LineBorder.createGrayLineBorder());
        informationLabel.setEditable(false);

        deleteButton = new JButton("Find");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String name = fieldName.getText();
                    dbConnection.deleteContact(name);
                    informationLabel.setText("Contact " + name + " has been deleted");
                }
                catch (SQLException sql){
                    System.out.println(sql);
                }
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = fieldName.getText();
                try{
                    informationLabel.setText(dbConnection.findContact(name));
                }
                catch(SQLException sql){
                    System.out.println(sql);
                }

            }
        });
        panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(300, 150));
        panel1.setLayout(new FlowLayout());
        panel1.setBackground(Color.ORANGE);

        panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(310, 100));
        panel2.setLayout(new FlowLayout());
        panel2.setBackground(Color.ORANGE);

        this.setSize(600, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.getContentPane().setBackground( Color.ORANGE );
        this.setTitle("Contacts");
        this.setResizable(false);

        this.add(label);
        this.add(panel1);

        panel1.add(fieldName);
        panel1.add(panel2);

        panel2.add(informationLabel);
        panel2.add(deleteButton);
    }
}
