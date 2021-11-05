package com.bof.bof.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class SwaggerController {
    @GetMapping("/swagger")
    public String getSwaggerPage(){
        return "redirect:/swagger-ui.html";
    }
}
