package com.example.demo.basic;

public class Student {
    private  Printer printer = new HpPrinter();
    public void learn()
    {
        printer.print("I am a Student");
    }
}
