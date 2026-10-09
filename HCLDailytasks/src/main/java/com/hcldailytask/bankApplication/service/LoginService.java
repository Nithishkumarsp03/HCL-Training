package com.hcldailytask.bankApplication.service;

public class LoginService {
    private final int password = 1212;
    private static int count = 0;
    private boolean loggedIn = false;
    public LoginService () {};

    public boolean userLocked () {
        return count == 3;
    }

    public boolean validateCredentials (int pass) {
        if(pass == password && count < 3) {
            System.out.println("Login Successfull!, Choose any one of the choice below to proceed");
            loggedIn=true;
            return true;
        }
        else {
            System.out.println("Login failed! Please try again.");
            count++;
        }
        return false;
    }

    public boolean userLoggedin () {
        return loggedIn;
    }
}
