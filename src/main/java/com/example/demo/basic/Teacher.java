package com.example.demo.basic;

public class Teacher {

    private Printer printer = new HpPrinter();

    public void teach() {
        printer.print("I am a teacher");
    }


}
