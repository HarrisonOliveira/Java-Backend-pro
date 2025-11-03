package com.ebac.projeto_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitialController {

    @GetMapping
    public String initial() {
        return "Hello World";
    }
}
