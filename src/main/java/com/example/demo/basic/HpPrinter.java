package com.example.demo.basic;

public class HpPrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println("HP印表機:" + message);
    }
}
