package dev.java10x.CadastroDeNinjas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NinjaController {

    @GetMapping("/hellospring")
    public String helloSpring(){
        return "Testando minha API.";
    }
}
