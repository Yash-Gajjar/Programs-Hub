package com.Interface;

interface IDisplayable {
    void display(String message);
    void sayHello();
}

public class SimpleInterface implements IDisplayable {
    public static void main(String[] args) {
        SimpleInterface simpleInterface = new SimpleInterface();

        simpleInterface.sayHello();
        simpleInterface.display("I Want This To Be Displayed!");
    }

    @Override
    public void display(String message) {
        System.out.println(message);
    }

    @Override
    public void sayHello() {
        System.out.println("Hello Brownie!");
    }
}
