package project.banking.service;

import project.banking.dao.AccountDao;

import java.sql.SQLException;
import java.util.Scanner;

public class AccountService {
    private final AccountDao accountDao;

    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void openAccount(String email, Scanner scanner) {
        try {
            if (accountDao.accountExists(email)) {
                System.out.println("Account already exists for this email.");
                return;
            }
            System.out.print("Enter Full Name: ");
            scanner.nextLine(); // Consume newline
            String fullName = scanner.nextLine();
            System.out.print("Enter Initial Amount: ");
            double initialAmount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Security Pin: ");
            String securityPin = scanner.nextLine();
            accountDao.openAccount(fullName, email, initialAmount, securityPin);
        } catch (SQLException e) {
//            e.printStackTrace();
        }
    }

    public void debitMoney(String email, Scanner scanner) {
        try {
            long accountNumber = accountDao.getAccountNumber(email);
            System.out.print("Enter amount to debit: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Security Pin: ");
            String securityPin = scanner.nextLine();
            accountDao.debitMoney(accountNumber, amount, securityPin);
        } catch (SQLException e) {
//            e.printStackTrace();
        }
    }

    public void creditMoney(String email, Scanner scanner) {
        try {
            long accountNumber = accountDao.getAccountNumber(email);
            System.out.print("Enter amount to credit: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Enter Security Pin: ");
            String securityPin = scanner.nextLine();
            accountDao.creditMoney(accountNumber, amount, securityPin);
        } catch (SQLException e) {
//            e.printStackTrace();
        }
    }

    public void transferMoney(String email, Scanner scanner) {
        try {
            long senderAccountNumber = accountDao.getAccountNumber(email);
            System.out.print("Enter recipient's account number: ");
            long receiverAccountNumber = scanner.nextLong();
            System.out.print("Enter amount to transfer: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Enter Security Pin: ");
            String securityPin = scanner.nextLine();
            accountDao.transferMoney(senderAccountNumber, receiverAccountNumber, amount, securityPin);
        } catch (SQLException e) {
//            e.printStackTrace();
        }
    }

    public void checkBalance(String email, Scanner scanner) {
        try {
            long accountNumber = accountDao.getAccountNumber(email);
                System.out.print("Enter Security Pin: ");
                String securityPin = scanner.next();
                scanner.nextLine();
                double balance = accountDao.getBalance(accountNumber, securityPin);
                System.out.println("Your account balance is: Rs." + balance);

        } catch (SQLException e) {
//            e.printStackTrace();
        }
    }
}
