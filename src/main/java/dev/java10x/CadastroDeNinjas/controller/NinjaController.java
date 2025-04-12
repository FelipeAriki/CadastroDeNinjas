package dev.java10x.CadastroDeNinjas.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class NinjaController {

    @GetMapping("/obter-ninjas")
    public String ObterNinjas(){
        return "Todos os ninjas";
    }

    @GetMapping("/obter-ninja")
    public String ObterNinja(){
        return "Ninja";
    }

    @PostMapping("/criar")
    public String CriarNinja(){
        return "Ninja criado com sucesso!";
    }

    @PutMapping("/alterar")
    public String AlterarNinja(){
        return "Ninja alterado com sucesso!";
    }

    @DeleteMapping("/deletar")
    public String DeletarNinja(){
        return "Deletar Ninja!";
    }
}
