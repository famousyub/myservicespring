package com.example.oauth.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/testy")
public class CheckUserController {


    @RequestMapping(value = "/products")
    public String getProductName() {
        return "Honey";
    }


}
