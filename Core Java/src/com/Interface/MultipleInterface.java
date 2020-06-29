package com.Interface;

interface ISaysHello {
    void sayHello();
}

interface IPrintsMessage {
    void printMessage(String message);
}

public class MultipleInterface implements ISaysHello, IPrintsMessage {
    public static void main(String[] args) {
        MultipleInterface multipleInterface = new MultipleInterface();

        multipleInterface.sayHello();
        multipleInterface.printMessage("Hey There! This is CoderBoy.");
    }

    @Override
    public void sayHello() {
        System.out.println("Hello Brownie!");
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }
}
