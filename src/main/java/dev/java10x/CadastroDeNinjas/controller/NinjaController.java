package dev.java10x.CadastroDeNinjas.controller;

import dev.java10x.CadastroDeNinjas.DTOs.NinjaDTO;
import dev.java10x.CadastroDeNinjas.service.NinjaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninja")
public class NinjaController {

    private final NinjaService ninjaService;

    NinjaController(NinjaService ninjaService){
        this.ninjaService = ninjaService;
    }

    @GetMapping("/obter-ninjas")
    public List<NinjaDTO> ObterNinjas(){
        return this.ninjaService.obterNinjas();
    }

    @GetMapping("/obter-ninja/{id}")
    public NinjaDTO ObterNinja(@PathVariable Long id){
        return this.ninjaService.obterNinja(id);
    }

    @PostMapping("/criar")
    public NinjaDTO CriarNinja(@RequestBody NinjaDTO ninja){
        return this.ninjaService.criarNinja(ninja);
    }

    @PutMapping("/alterar/{id}")
    public NinjaDTO AlterarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninja){
        return this.ninjaService.alterarNinja(id, ninja);
    }

    @DeleteMapping("/deletar/{id}")
    public void DeletarNinja(@PathVariable Long id){
        this.ninjaService.deletarNinja(id);
    }
}
