package com.testlesson.contactbook.JDBC;

import java.sql.*;

public class DBConnection {
    private static final String url = "jdbc:mysql://localhost:3306/testschema";
    private static final String username = "root";
    private static final String password = "1234";
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;

    public DBConnection(){
        try{
            connection = DriverManager.getConnection(url, username, password);

            statement = connection.createStatement();
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }

    public void addContact(String name, String phoneNumber) throws SQLException{
        String insertQuery = "INSERT INTO contacts (name, phone_number) VALUES (?, ?)";

        String clientName = name;
        String clientPhone = phoneNumber;

        preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, clientName);
        preparedStatement.setString(2, clientPhone);
        preparedStatement.executeUpdate();
    }
    public String deleteContact(String name) throws SQLException{

        String selectQuery = "SELECT * FROM contacts WHERE name='" + name + "';";
        ResultSet resultSet = statement.executeQuery(selectQuery);

        if (!resultSet.next()) {
            return "Contact " + name + " does not exist.";
        }
        String deleteQuery = "DELETE FROM contacts WHERE name='" + name + "';";
        statement.executeUpdate(deleteQuery);
        return "The contact has been deleted.";
    }
    public String findContact(String name) throws SQLException{
        String selectQuery = "SELECT * FROM contacts WHERE name='" + name + "';";
        String clientName = "error";
        String clientPhone = "error";

        resultSet = statement.executeQuery(selectQuery);

        while (resultSet.next()) {
            clientName = resultSet.getString("name");
            clientPhone = resultSet.getString("phone_number");


        }
        if(clientName.equals("error") || clientPhone.equals("error")){
            return "Contact is not found";
        }
        return "Name: " + clientName + " | Phone: " + clientPhone;
    }

    public void closeAll() throws SQLException{
        connection.close();
        statement.close();
        preparedStatement.close();
    }
}
