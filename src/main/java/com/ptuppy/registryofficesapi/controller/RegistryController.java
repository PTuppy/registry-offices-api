package com.ptuppy.registryofficesapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registry")
public class RegistryController {

    @GetMapping
    public String home() {
        return "/home";
    }


}
