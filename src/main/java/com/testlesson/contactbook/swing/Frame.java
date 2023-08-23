package com.testlesson.contactbook.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    private JButton addButton;
    private JButton findButton;
    private JButton deleteButton;
    private JButton okButton;
    private JPanel buttonPanel;
    private JLabel label;
    public Frame(){
        label = new JLabel("Hello, choose the operation");
        label.setFont(new Font("MV Boli", Font.PLAIN, 30));

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setSize(600, 70);


        addButton = new JButton("Add");
        findButton = new JButton("Find");
        deleteButton = new JButton("Delete");
        okButton = new JButton("OK");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddFrame();
            }
        });
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FindFrame();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteFrame();
            }
        });

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 300);
        this.setLayout(new FlowLayout());
        this.setBackground(Color.blue);
        this.setTitle("Contacts");
        this.getContentPane().setBackground( Color.ORANGE );
        this.setResizable(false);

        this.add(label);
        this.add(buttonPanel);

        buttonPanel.add(addButton);
        buttonPanel.add(findButton);
        buttonPanel.add(deleteButton);
    }
}
