package com.testlesson.contactbook.JDBC;

import java.sql.*;

public class DBConnection {
    private String url = "jdbc:mysql://localhost:3306/testschema";
    private String username = "root";
    private String password = "1234";
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;

    public DBConnection(){
        try{
            // Встановлення з'єднання
            connection = DriverManager.getConnection(url, username, password);

            // Створення об'єкта для виконання SQL-запитів
            statement = connection.createStatement();

            String query = "SELECT * FROM contacts";
            resultSet = statement.executeQuery(query);

            // Обробка результатів запиту
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("first_name");
                String surname = resultSet.getString("last_name");
                // Додаткові поля з бази даних
                // ...

                System.out.println("ID: " + id + ", Name: " + name + ", Surname: " + surname);
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }

    public void addContact(String name, String phoneNumber) throws SQLException{
        String insertQuery = "INSERT INTO contacts (name, phone_number) VALUES (?, ?)";

        // Заповнення даних клієнта
        String clientName = "John Doe";
        String clientPhone = "123-456-7890";

        // Підготовка запиту
        preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, clientName);
        preparedStatement.setString(2, clientPhone);
        preparedStatement.executeUpdate();
    }
    public void closeAll() throws SQLException{
        connection.close();
        statement.close();
        preparedStatement.close();
        resultSet.close();
    }
}
