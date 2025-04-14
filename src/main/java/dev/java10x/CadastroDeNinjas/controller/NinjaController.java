package dev.java10x.CadastroDeNinjas.controller;

import dev.java10x.CadastroDeNinjas.models.NinjaModel;
import dev.java10x.CadastroDeNinjas.service.NinjaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninja")
public class NinjaController {

    private NinjaService ninjaService;

    NinjaController(NinjaService ninjaService){
        this.ninjaService = ninjaService;
    }

    @GetMapping("/obter-ninjas")
    public List<NinjaModel> ObterNinjas(){
        return this.ninjaService.obterNinjas();
    }

    @GetMapping("/obter-ninja/{id}")
    public NinjaModel ObterNinja(@PathVariable Long id){
        return this.ninjaService.obterNinja(id);
    }

    @PostMapping("/criar")
    public NinjaModel CriarNinja(@RequestBody NinjaModel ninja){
        return this.ninjaService.criarNinja(ninja);
    }

    @PutMapping("/alterar/{id}")
    public NinjaModel AlterarNinja(@PathVariable Long id, @RequestBody NinjaModel ninja){
        return this.ninjaService.alterarNinja(id, ninja);
    }

    @DeleteMapping("/deletar/{id}")
    public void DeletarNinja(@PathVariable Long id){
        this.ninjaService.deletarNinja(id);
    }
}
