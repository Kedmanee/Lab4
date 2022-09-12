package com.example.lab4;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cashier {
    @RequestMapping(value = "/getChange/{num}", method = RequestMethod.GET)
    public Change getChange(@PathVariable("num") int num){
        Change change = new Change();
        change.setB1000(num/1000);
        num = num % 1000;
        change.setB500(num/500);
        num = num % 500;
        change.setB100(num/100);
        num = num % 100;
        change.setB20(num/20);
        num = num % 20;
        change.setB10(num/10);
        num = num % 10;
        change.setB5(num/5);
        num = num % 5;
        change.setB1(num);
        return change;
    }
}
