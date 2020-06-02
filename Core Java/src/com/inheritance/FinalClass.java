package com.inheritance;

// The final class cannot be extended
final class SupClass {
    void sayHello() {
        System.out.println("Hello!");
    }
}

// class baseClass extends SupClass { } // This Will Throw Error

public class FinalClass {
    public static void main(String[] args) {
        SupClass supClass = new SupClass();
        supClass.sayHello();
    }
}
