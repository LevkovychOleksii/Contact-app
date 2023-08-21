package com.testlesson.contactbook.swing;

import com.testlesson.contactbook.Entity.Contact;

import javax.swing.*;
import java.awt.*;

public class DeleteFrame extends JFrame {
    private Contact contact;
    private JLabel label;
    private JTextField fieldName;
    private JTextField phoneNumber;
    private JButton delete;
    private JPanel panel1;
    private JPanel panel2;
    public DeleteFrame(){
        label = new JLabel("Write information to delete");
        label.setFont(new Font("MV Boli", Font.PLAIN, 30));

        delete = new JButton("Delete");

        fieldName = new JTextField("Name");
        fieldName.setPreferredSize(new Dimension(200, 30));

        phoneNumber = new JTextField("Phone");
        phoneNumber.setPreferredSize(new Dimension(200, 30));

        panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(600, 100));
        panel1.setLayout(new FlowLayout());
        panel1.setBackground(Color.ORANGE);

        panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(600, 100));
        panel2.setBackground(Color.ORANGE);


        this.setSize(600, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.getContentPane().setBackground( Color.ORANGE );
        this.setTitle("Contacts");

        this.add(label);
        this.add(panel1);

        panel1.add(fieldName);
        panel1.add(phoneNumber);
        panel1.add(panel2);
        panel2.add(delete);


    }
}
