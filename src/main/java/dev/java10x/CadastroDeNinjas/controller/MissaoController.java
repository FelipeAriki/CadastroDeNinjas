package dev.java10x.CadastroDeNinjas.controller;

import dev.java10x.CadastroDeNinjas.models.MissaoModel;
import dev.java10x.CadastroDeNinjas.service.MissaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missao")
public class MissaoController {
    private MissaoService missaoService;
    MissaoController(MissaoService missaoService){
        this.missaoService = missaoService;
    }

    @GetMapping("/obter-missoes")
    public List<MissaoModel> ObterMissoes(){
        return this.missaoService.obterMissoes();
    }

    @GetMapping("/obter-missao/{id}")
    public MissaoModel ObterMissao(@PathVariable Long id) {
        return this.missaoService.obterMissao(id);
    }

    @PostMapping("/criar")
    public MissaoModel CriarMissao(@RequestBody MissaoModel missaoModel){
        return this.missaoService.criarMissao(missaoModel);
    }

    @PutMapping("/alterar/{id}")
    public MissaoModel AlterarMissao(@PathVariable Long id, @RequestBody MissaoModel missaoModel){
        return this.missaoService.atualizarMissao(id, missaoModel);
    }

    @DeleteMapping("/deletar/{id}")
    public void DeletarMissao(@PathVariable Long id){
        this.missaoService.deletarMissao(id);
    }
}
