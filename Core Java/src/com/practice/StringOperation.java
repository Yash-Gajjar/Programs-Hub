package com.practice;

public class StringOperation {
    public static void main(String[] args) {

        basicMethodsDemo();

        emailValidation();

    }

    private static void emailValidation() {

        String email = "Coder.Boy@gmail.com";   //  Valid Email
        String email1 = "Coder.Boy@g.com";      // Invalid Email
        String email2 = "Coder.Boy@gmail.c";    // Invalid Email
        String email3 = "Coder.Boy.gmail.com";  // Invalid Email

        if (email.contains("@")) // Checking for "@" character
            if (email.lastIndexOf(".") - email.lastIndexOf("@") > 2) // Checking for valid company name
                if (email.length() - 1 - email.lastIndexOf(".") > 2) // Checking for valid domain extension
                    System.out.println(email + " is Valid Email!");
                else System.out.println(email + " does not contain valid Domain Extension!");
            else System.out.println(email + " does not contain valid Company name!");
        else System.out.println(email + " does not contain \"@\" character!");

        System.out.println();

//        The above method can be shortened by the following way

        if (email1.contains("@") && (email1.lastIndexOf(".") - email1.lastIndexOf("@") > 2) && (email1.length() - 1 - email1.lastIndexOf(".") > 2))
            System.out.println(email1 + " is Valid Email!");
        else System.out.println(email1 + " is not a Valid Email!");

        System.out.println();

        if (email2.contains("@") && (email2.lastIndexOf(".") - email2.lastIndexOf("@") > 2) && (email2.length() - 1 - email2.lastIndexOf(".") > 2))
            System.out.println(email2 + " is Valid Email!");
        else System.out.println(email2 + " is not a Valid Email!");

        System.out.println();

        if (email3.contains("@") && (email3.lastIndexOf(".") - email3.lastIndexOf("@") > 2) && (email3.length() - 1 - email3.lastIndexOf(".") > 2))
            System.out.println(email3 + " is Valid Email!");
        else System.out.println(email3 + " is not a Valid Email!");

    }

    private static void basicMethodsDemo() {

//        There are multiple ways to declare String
        String name = "CoderBoy";
        String name2 = new String("CoderBoy");

        String name1 = "CoderBoy";

//        this matches object, hence it'll return false
        if (name == name2) System.out.println("name and name2 matched!");
        else System.out.println("name and name2 didn't match!");

//        this will return true
        System.out.println((name == name1) ? "name and name1 matched!" : "name and name1 didn't match!");


//        this checks for values
        if (name.equals(name2)) System.out.println("name and name2 matched!");
        else System.out.println("name and name2 didn't match!");

    }
}
