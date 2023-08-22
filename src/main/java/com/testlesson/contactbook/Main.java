package com.testlesson.contactbook;

import com.testlesson.contactbook.JDBC.DBConnection;
import com.testlesson.contactbook.swing.*;
import com.testlesson.contactbook.swing.Frame;

import javax.swing.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
         JFrame frame = new FindFrame();
//        DBConnection db = new DBConnection();
//        db.findContact("Johny");
//
//        db.addContact("John Kock", "123-123-123");
//        db.closeAll();
    }

}