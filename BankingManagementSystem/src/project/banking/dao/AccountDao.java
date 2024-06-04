package project.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao {
    private final Connection connection;

    public AccountDao(Connection connection) {
        this.connection = connection;
    }

    public boolean accountExists(String email) throws SQLException {
        String query = "SELECT account_number FROM Accounts WHERE email = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        }
    }

    public void openAccount(String fullName, String email, double initialAmount, String securityPin) throws SQLException {
        String openAccountQuery = "INSERT INTO Accounts(account_number, full_name, email, balance, security_pin) VALUES(?, ?, ?, ?, ?)";
        long accountNumber = generateAccountNumber();
        try (PreparedStatement preparedStatement = connection.prepareStatement(openAccountQuery)) {
            preparedStatement.setLong(1, accountNumber);
            preparedStatement.setString(2, fullName);
            preparedStatement.setString(3, email);
            preparedStatement.setDouble(4, initialAmount);
            preparedStatement.setString(5, securityPin);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Account Created Successfully. Your Account Number is: " + accountNumber);
            } else {
                throw new RuntimeException("Account Creation failed!!");
            }
        }
    }

    public long getAccountNumber(String email) throws SQLException {
        String query = "SELECT account_number FROM Accounts WHERE email = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getLong("account_number");
                } else {
                    throw new RuntimeException("Account Number Doesn't Exist!");
                }
            }
        }
    }

    private long generateAccountNumber() throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT account_number FROM Accounts ORDER BY account_number DESC LIMIT 1");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getLong("account_number") + 1;
            } else {
                return 10000100;
            }
        }
    }

    public void debitMoney(long accountNumber, double amount, String securityPin) throws SQLException {
        String query = "UPDATE Accounts SET balance = balance - ? WHERE account_number = ? AND security_pin = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, amount);
            preparedStatement.setLong(2, accountNumber);
            preparedStatement.setString(3, securityPin);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Rs." + amount + " debited successfully");
            } else {
                throw new RuntimeException("Debit transaction failed!");
            }
        }
    }

    public void creditMoney(long accountNumber, double amount, String securityPin) throws SQLException {
        String query = "UPDATE Accounts SET balance = balance + ? WHERE account_number = ? AND security_pin = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, amount);
            preparedStatement.setLong(2, accountNumber);
            preparedStatement.setString(3, securityPin);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Rs." + amount + " credited successfully");
            } else {
                throw new RuntimeException("Credit transaction failed!");
            }
        }
    }

    public void transferMoney(long senderAccountNumber, long receiverAccountNumber, double amount, String securityPin) throws SQLException {
        connection.setAutoCommit(false);
        try {
            debitMoney(senderAccountNumber, amount, securityPin);
            creditMoney(receiverAccountNumber, amount, securityPin);
            connection.commit();
            System.out.println("Rs." + amount + " transferred successfully");
        } catch (SQLException e) {
            connection.rollback();
            throw new RuntimeException("Transfer transaction failed!", e);
        } finally {
            connection.setAutoCommit(true);
        }
    }

    public double getBalance(long accountNumber, String securityPin) throws SQLException {
        String query = "SELECT balance FROM Accounts WHERE account_number = ? AND security_pin = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, accountNumber);
            preparedStatement.setString(2, securityPin);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getDouble("balance");
                } else {
//                    throw new RuntimeException("Invalid Security Pin or Account Number!");
                    System.out.println("AAP KA SECURITY PIN GALAT HAI");
                }
        }
    }
        return 0;
    }
}
