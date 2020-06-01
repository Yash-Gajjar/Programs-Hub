package com.practice;

public class StaticConcepts {
    public static void main(String[] args) {

        Nango nango = new Nango();
        System.out.println(Nango.name);

    }
}

class Nango {
    public static String name ;

    public Nango() {
        System.out.println("In Constructor!");
    }

    static {
        name = "CoderBoy" ;
        System.out.println("In Static Block!");
    }

}
