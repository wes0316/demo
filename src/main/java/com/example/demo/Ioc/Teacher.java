package com.example.demo.Ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
public class Teacher {
   // @Autowired
   // @Qualifier("canonPrinter")//指定要HP還是Canon印表機實體，首字均為小寫
    private  Printer printer;

    public void teach()
    {
        printer.print("I'm a Teacher");
    }
}
