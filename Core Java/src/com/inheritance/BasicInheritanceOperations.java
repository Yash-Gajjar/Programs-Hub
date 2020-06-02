package com.inheritance;

class Instrument {
    String typeOfInstrument;

    public Instrument() {
        this.typeOfInstrument = null;
    }

    public Instrument(String typeOfInstrument) {
        this.typeOfInstrument = typeOfInstrument;
    }

    void showType() {
        System.out.println("The Instrument Type Is: " + this.typeOfInstrument);
    }
}

class Harmonica extends Instrument {
    private final String name;

    public Harmonica() {
        this.name = null;
    }

    public Harmonica(String typeOfInstrument, String name) {
        super(typeOfInstrument);
        this.name = name;
    }

    public void details() {
        System.out.println("Instrument Type: " + typeOfInstrument);
        System.out.println("Instrument Name: " + name);
    }
}

public class BasicInheritanceOperations {
    public static void main(String[] args) {
        Harmonica harmonica = new Harmonica();
        harmonica.showType();
        harmonica.details();

        Harmonica harmonica1 = new Harmonica("Musical", "Mouth Organ");
        harmonica1.showType();
        harmonica1.details();

        Instrument instrument = new Harmonica("Musical", "Guitar");
        instrument.showType();
//        instrument.details() ; // This Line Throws Error. Base Class Can't access Properties & Methods of Derived Class.
    }
}
