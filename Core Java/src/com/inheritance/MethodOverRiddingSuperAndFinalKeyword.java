package com.inheritance;

class SuperClass {
    void whoIs() {
        System.out.println("I'm SupperClass !!");
    }

    final void finalMethod(){
        System.out.println("This Cannot be Overridden by any Derived Class.");
    }
}

class DerivedClass extends SuperClass {
    void whoIs() {
        super.whoIs() ;
        System.out.println("I'm Derived Class !!");
    }
}

public class MethodOverRiddingSuperAndFinalKeyword {
    public static void main(String[] args) {
        DerivedClass derivedClass = new DerivedClass() ;
        derivedClass.whoIs();
    }
}
