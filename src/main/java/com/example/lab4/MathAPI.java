package com.example.lab4;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathAPI {
    @RequestMapping(value = "/plus/{num1}/{num2}", method = RequestMethod.GET)
    public double myPlus(@PathVariable("num1") double num1, @PathVariable("num2") double num2){
        return num1+num2;
    }
    @RequestMapping(value = "/minus/{num1}/{num2}", method = RequestMethod.GET)
    public double myMinus(@PathVariable("num1") double num1, @PathVariable("num2") double num2) {
        return num1 - num2;
    }
    @RequestMapping(value = "/divide/{num1}/{num2}", method = RequestMethod.GET)
    public double myDivide(@PathVariable("num1") double num1, @PathVariable("num2") double num2) {
        return num1 / num2;
    }
    @RequestMapping(value = "/multiply/{num1}/{num2}", method = RequestMethod.GET)
    public double myMulti(@PathVariable("num1") double num1, @PathVariable("num2") double num2) {
        return num1 * num2;
    }
    @RequestMapping(value = "/mod/{num1}/{num2}", method = RequestMethod.GET)
    public double myMod(@PathVariable("num1") double num1, @PathVariable("num2") double num2) {
        return num1 % num2;
    }
    @RequestMapping(value = "/max", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public double myMax(@RequestBody MaxValue num) {
        if (num.a>num.b){
            return num.a;
        }
        return num.b;
    }
}
