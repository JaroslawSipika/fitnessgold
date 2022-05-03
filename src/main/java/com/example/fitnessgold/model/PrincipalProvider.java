package com.example.fitnessgold.model;

import org.springframework.stereotype.Component;

@Component
public class PrincipalProvider {

    private static User currentUser;
    private static String userType;

    public static void setUserType(String userType1){
        userType = userType1;
    }

    public static User getCurrentUser() {
        if (currentUser != null) {
            return currentUser;
        } else {
            throw new RuntimeException("Missing currently authenticated user!");
        }
    }

    public static void storeCurrentUser(User user) {
        if (user != null) {
            System.out.println("Storing current user");
            currentUser = user;
        } else {
            throw new RuntimeException("User cannot be null!");
        }
    }

    public static void clearCurrentUser() {
        System.out.println("Removing current user");
        currentUser = null;
        userType = null;
    }

    public static boolean isAdmin(){
        return "ADMIN".equals(userType);
    }
    public static boolean isClient(){
        return "CLIENT".equals(userType);
    }
    public static boolean isEmployee(){
        return "EMPLOYEE".equals(userType);
    }

}