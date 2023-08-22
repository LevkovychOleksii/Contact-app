package com.testlesson.contactbook.swing;

import com.testlesson.contactbook.Entity.Contact;
import com.testlesson.contactbook.JDBC.DBConnection;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class FindFrame extends JFrame {
    private Contact contact;
    private JLabel label;
    private JTextField informationLabel;
    private JTextField fieldName;
    private JTextField phoneNumber;
    private JButton find;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private DBConnection dbConnection;
    public FindFrame(){
        dbConnection = new DBConnection();
        label = new JLabel("Write information to find");
        label.setFont(new Font("MV Boli", Font.PLAIN, 30));

        fieldName = new JTextField("Name");
        fieldName.setPreferredSize(new Dimension(200, 30));

        informationLabel = new JTextField("Information");
        informationLabel.setPreferredSize(new Dimension(250, 30));
        informationLabel.setBackground(Color.YELLOW);
        // Створюємо об'єкт рамки з бажаним кольором
//        Border border = LineBorder.createBlackLineBorder();

        // Встановлюємо рамку для JTextField
        informationLabel.setBorder(LineBorder.createGrayLineBorder());

//        phoneNumber = new JTextField("Phone");
//        phoneNumber.setPreferredSize(new Dimension(200, 30));
        find = new JButton("Find");
        find.addActionListener(new ActionListener() {
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

        panel3 = new JPanel();
        panel3.setPreferredSize(new Dimension(300, 50));
        panel3.setBackground(Color.BLACK);

        this.setSize(600, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.getContentPane().setBackground( Color.ORANGE );
        this.setTitle("Contacts");

        this.add(label);
        this.add(panel1);

        panel1.add(fieldName);
//        panel1.add(informationLabel);
        panel1.add(panel2);
//        panel1.add(panel3);
        panel2.add(informationLabel);
        panel2.add(find);
//        panel3.add(informationLabel);


    }
}
