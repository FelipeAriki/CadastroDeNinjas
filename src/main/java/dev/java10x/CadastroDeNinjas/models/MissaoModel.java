package dev.java10x.CadastroDeNinjas.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "missao")
public class MissaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    private String dificuldade;

    @OneToMany(mappedBy = "missao")
    private List<NinjaModel> ninja;
}
