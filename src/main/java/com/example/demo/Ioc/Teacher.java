package com.example.demo.Ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Teacher {

    private  Printer printer;

    public void teach()
    {
        printer.print("I'm a Teacher");
    }
}
