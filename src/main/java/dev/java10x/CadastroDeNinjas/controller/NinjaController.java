package dev.java10x.CadastroDeNinjas.controller;

import dev.java10x.CadastroDeNinjas.DTOs.NinjaDTO;
import dev.java10x.CadastroDeNinjas.service.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> ObterNinjas() {
        List<NinjaDTO> ninjas =  this.ninjaService.obterNinjas();
        return ResponseEntity.ok(ninjas);
    }

    @GetMapping("/obter-ninja/{id}")
    public ResponseEntity<?> ObterNinja(@PathVariable Long id){
        NinjaDTO ninja = this.ninjaService.obterNinja(id);
        return ResponseEntity.ok(ninja);
    }

    @PostMapping("/criar")
    public ResponseEntity<?> CriarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = this.ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> AlterarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        NinjaDTO ninja = this.ninjaService.alterarNinja(id, ninjaAtualizado);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id: " + id + " nao existe nos nossos registros");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> DeletarNinja(@PathVariable Long id){
        if(this.ninjaService.obterNinja(id) != null){
            this.ninjaService.deletarNinja(id);
            return ResponseEntity.ok("Ninja com o ID: " + id + "excluído com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Ninja não encontrado!");
    }
}
