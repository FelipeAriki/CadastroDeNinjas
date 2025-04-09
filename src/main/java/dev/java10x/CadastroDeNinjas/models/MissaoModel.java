package dev.java10x.CadastroDeNinjas.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "missao")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    private String dificuldade;

    @OneToMany(mappedBy = "missao")
    private List<NinjaModel> ninja;
}
