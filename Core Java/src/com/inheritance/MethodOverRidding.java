package com.inheritance;

class Sup {
    void whoIs() {
        System.out.println("I'm Sup!!");
    }
}

class Sup1 extends Sup {
    void whoIs() {
        System.out.println("I'm Sup1!!");
    }
}

class Sup2 extends Sup1 {
    void whoIs() {
        System.out.println("I'm Sup2!!");
    }
}

public class MethodOverRidding {
    public static void main(String[] args) {
        Sup sup = new Sup();
        Sup1 sup1 = new Sup1();
        Sup2 sup2 = new Sup2();

        Sup sup3 ;

        sup3 = sup ;
        sup3.whoIs();

        sup3 = sup1 ;
        sup3.whoIs();

        sup3 = sup2 ;
        sup3.whoIs();
    }
}
