package project.banking.service;

import project.banking.dao.UserDao;

import java.sql.SQLException;

public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void registerUser(String fullName, String email, String password) {
        try {
            if (userDao.userExists(fullName,email)) {
                System.out.println("ye USERNAME PAHLE SE HAI");
            } else {
                userDao.register(fullName, email, password);
                System.out.print("BADHAI HO----");
                System.out.println("AAP KI REGISTRY HO GAI");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean loginUser(String email, String password) {
        try {
            return userDao.login(email, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
