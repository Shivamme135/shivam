package project.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private final Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }

    public boolean userExists(String fullName,String email) throws SQLException {
        String query = "SELECT * FROM user WHERE full_name = ? OR email = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
           preparedStatement.setString(1,fullName);
            preparedStatement.setString(2, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        }
    }

    public void register(String fullName, String email, String password) throws SQLException {
        String registerQuery = "INSERT INTO User(full_name, email, password) VALUES(?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(registerQuery)) {
            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Registration Successful!");
            } else {
                System.out.println("Registration Failed!");
            }
        }
    }

    public boolean login(String email, String password) throws SQLException {
        String loginQuery = "SELECT * FROM User WHERE email = ? AND password = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(loginQuery)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        }
    }
}
