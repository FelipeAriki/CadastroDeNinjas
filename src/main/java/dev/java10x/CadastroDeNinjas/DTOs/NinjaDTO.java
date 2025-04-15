package dev.java10x.CadastroDeNinjas.DTOs;

import dev.java10x.CadastroDeNinjas.models.MissaoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaDTO {
    private Long id;
    private String nome;
    private String email;
    private String rank;
    private String imgUrl;
    private int idade;
    private MissaoModel missao;
}
