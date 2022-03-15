package com.example.demo.basic;

public class Student {
    private Printer printer = new HpPrinter();
    private Printer printer1 = new CanonPrinter();

    public void learn() {
        printer.print("I am a Student");
        printer1.print("I am a Student");
    }
}
