package dev.java10x.CadastroDeNinjas.controller;

import dev.java10x.CadastroDeNinjas.DTOs.MissaoDTO;
import dev.java10x.CadastroDeNinjas.service.MissaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> ObterMissoes(){
        List<MissaoDTO> missoes =  this.missaoService.obterMissoes();
        return ResponseEntity.ok(missoes);
    }

    @GetMapping("/obter-missao/{id}")
    public ResponseEntity<?> ObterMissao(@PathVariable Long id) {
        MissaoDTO missao = this.missaoService.obterMissao(id);
        return ResponseEntity.ok(missao);
    }

    @PostMapping("/criar")
    public ResponseEntity<?> CriarMissao(@RequestBody MissaoDTO missaoDTO){
        MissaoDTO novaMissao = this.missaoService.criarMissao(missaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criada com sucesso: " + novaMissao.getNome() + " (ID): " + novaMissao.getId());
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> AlterarMissao(@PathVariable Long id, @RequestBody MissaoDTO missaoDTO){
        MissaoDTO missao = this.missaoService.atualizarMissao(id, missaoDTO);
        if (missao != null) {
            return ResponseEntity.ok(missao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com o id: " + id + " nao existe nos nossos registros!");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> DeletarMissao(@PathVariable Long id){
        if(this.missaoService.obterMissao(id) != null){
            this.missaoService.deletarMissao(id);
            return ResponseEntity.ok("Missão com o ID: " + id + "excluído com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Missão não encontrada!");
    }
}
