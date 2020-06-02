package com.practice;

class ErrorMessages {

//    final variables are constants
//    Its values cannot be changed further
    public static final String ERROR_400 = "Bad Request!";
    public static final String ERROR_401 = "Unauthorized!";
    public static final String ERROR_402 = "Payment Required!";
    public static final String ERROR_403 = "Forbidden";
    public static final String ERROR_404 = "Not FOUND!";
    public static final String ERROR_405 = "Methods Not Allowed!";
    public static final String ERROR_406 = "Not Acceptable!";
    public static final String ERROR_407 = "Proxy Authentication Required!";
}

public class FinalVariables {
    public static void main(String[] args) {

        System.out.println("Error Message for Error 400: " + ErrorMessages.ERROR_400);
        System.out.println("Error Message for Error 401: " + ErrorMessages.ERROR_401);
        System.out.println("Error Message for Error 402: " + ErrorMessages.ERROR_402);
        System.out.println("Error Message for Error 403: " + ErrorMessages.ERROR_403);
        System.out.println("Error Message for Error 404: " + ErrorMessages.ERROR_404);
        System.out.println("Error Message for Error 405: " + ErrorMessages.ERROR_405);
        System.out.println("Error Message for Error 406: " + ErrorMessages.ERROR_406);
        System.out.println("Error Message for Error 407: " + ErrorMessages.ERROR_407);

    }
}
