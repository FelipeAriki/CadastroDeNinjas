package dev.java10x.CadastroDeNinjas.DTOs;

import dev.java10x.CadastroDeNinjas.models.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissaoDTO {
    private Long id;
    private String nome;
    private String dificuldade;
    private List<NinjaModel> ninja;
}
