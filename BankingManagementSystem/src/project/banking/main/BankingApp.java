package project.banking.main;

import project.banking.dao.AccountDao;
import project.banking.dao.UserDao;
import project.banking.service.AccountService;
import project.banking.service.UserService;
import project.banking.util.DBUtil;

import java.sql.Connection;
import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
        Connection connection = DBUtil.getConnection();
        if (connection == null) {
            System.out.println("Failed to establish database connection.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        UserDao userDao = new UserDao(connection);
        UserService userService = new UserService(userDao);
        AccountDao accountDao = new AccountDao(connection);
        AccountService accountService = new AccountService(accountDao);

        while (true) {
            System.out.println("SWAGAT HAI AAP LOGO KA BANK ME");
            System.out.println();
            System.out.println("1. Register kare");
            System.out.println("2. Login kare");
            System.out.println("3. bahr nikalo");

            System.out.print("Enter your choice:");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("AAP KA PURA NAAM: ");
                    scanner.nextLine();
                    String fullName = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    userService.registerUser(fullName, email, password);
                    break;
                case 2:
                    System.out.print("Email: ");
                    scanner.nextLine();
                    String loginEmail = scanner.nextLine();
                    System.out.print("Password: ");
                    String loginPassword = scanner.nextLine();
                    if (userService.loginUser(loginEmail, loginPassword)) {
                        System.out.println("Login Successful!");
                        handleLoggedInUserActions(scanner, loginEmail, accountService);
                    } else {
                        System.out.println("GALAT EMAIL OR PASSWORD DALA HAI AAP NE CHECK KRE");
                    }
                    break;
                case 3:
                    System.out.println("DHANYABAD BANK ME AANE KE LIYE!!!");
                    System.out.println("TO HUM CHALTE HAI BYE");
                    return;
                default:
                    System.out.println("CHOICE SE BAHR JA RHE HAI AAP");
                    break;
            }
        }
    }

    private static void handleLoggedInUserActions(Scanner scanner, String email, AccountService accountService) {
        while (true) {
            System.out.println();
            System.out.println("1. Open a new Bank Account");
            System.out.println("2. Debit Money");
            System.out.println("3. Credit Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. Check Balance");
            System.out.println("6. Log Out");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    accountService.openAccount(email, scanner);
                    break;
                case 2:
                    accountService.debitMoney(email, scanner);
                    break;
                case 3:
                    accountService.creditMoney(email, scanner);
                    break;
                case 4:
                    accountService.transferMoney(email, scanner);
                    break;
                case 5:
                    accountService.checkBalance(email, scanner);
                    break;
                case 6:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Enter a valid choice.");
                    break;
            }
        }
    }
}
