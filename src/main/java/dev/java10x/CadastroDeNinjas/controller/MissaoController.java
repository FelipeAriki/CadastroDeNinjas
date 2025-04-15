package dev.java10x.CadastroDeNinjas.controller;

import dev.java10x.CadastroDeNinjas.DTOs.MissaoDTO;
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
    public List<MissaoDTO> ObterMissoes(){
        return this.missaoService.obterMissoes();
    }

    @GetMapping("/obter-missao/{id}")
    public MissaoDTO ObterMissao(@PathVariable Long id) {
        return this.missaoService.obterMissao(id);
    }

    @PostMapping("/criar")
    public MissaoDTO CriarMissao(@RequestBody MissaoDTO missaoDTO){
        return this.missaoService.criarMissao(missaoDTO);
    }

    @PutMapping("/alterar/{id}")
    public MissaoDTO AlterarMissao(@PathVariable Long id, @RequestBody MissaoDTO missaoDTO){
        return this.missaoService.atualizarMissao(id, missaoDTO);
    }

    @DeleteMapping("/deletar/{id}")
    public void DeletarMissao(@PathVariable Long id){
        this.missaoService.deletarMissao(id);
    }
}
