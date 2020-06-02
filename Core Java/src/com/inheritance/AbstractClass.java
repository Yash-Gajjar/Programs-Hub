package com.inheritance;

abstract class Multiply {

    void sayHello() {
        System.out.println("Hello Brownie!!");
    }

//    Derived class has to override the abstract methods
    abstract void multiplyNumber(int number);
}

class Multiplyer extends Multiply {

//    Overriding the abstract method
    @Override
    void multiplyNumber(int number) {
        System.out.println("After Multiplying: " + (number * 2));
    }
}

public class AbstractClass {
    public static void main(String[] args) {
        Multiplyer multiplyer = new Multiplyer();
        multiplyer.multiplyNumber(5);
        multiplyer.sayHello();

//        Creating the Object of Abstract class
//        abstract methods have to be overridden at the time of object creation
        Multiply multiply = new Multiply() {
            @Override
            void multiplyNumber(int number) {
                System.out.println(number * 2);
            }
        };

        multiply.multiplyNumber(10);
    }
}
