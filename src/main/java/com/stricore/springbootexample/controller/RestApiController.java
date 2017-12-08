/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stricore.springbootexample.controller;



import com.stricore.springbootexample.bean.Datos;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.stricore.springbootexample.bean.Datos;

 

/**
 *
 * @author Juan
 */

@RestController
public class RestApiController implements ErrorController{

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Datos greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Datos((int) counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping("/saludos")
    public String saludos() {
        return "Hola";
    }
    
    @RequestMapping("/error")
    public String error() {
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}