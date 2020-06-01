package com.practice;

public class NestedClass {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass("Hello Brownie!!") ;
        outerClass.displayString() ;

        AnotherOuterClass anotherOuterClass = new AnotherOuterClass() ;
        AnotherOuterClass.AnotherInnerClass anotherInnerClass = new AnotherOuterClass.AnotherInnerClass();

        ClassInsideMethod classInsideMethod = new ClassInsideMethod() ;
        classInsideMethod.displayDouble(5);
    }
}

class OuterClass {
    private final String s;

    public OuterClass(String s) {
        this.s = s ;
    }

    public void displayString() {
        InnerClass innerClass = new InnerClass() ;
        innerClass.printString();
    }

    class InnerClass {
        void printString() {
            String s1  = s ;
            System.out.println("String Is: " + s1);
        }
    }
}

class AnotherOuterClass {

    public AnotherOuterClass() {
        System.out.println("In Another Outer Class!");
    }

    static class AnotherInnerClass {
        public AnotherInnerClass() {
            System.out.println("In Another Inner Class!!");
        }
    }

}

class ClassInsideMethod {

    void displayDouble(int number) {

        class Doubler {
            void display(){
                System.out.println(number*2);
            }
        }

        Doubler doubler = new Doubler() ;
        doubler.display();
    }

}
