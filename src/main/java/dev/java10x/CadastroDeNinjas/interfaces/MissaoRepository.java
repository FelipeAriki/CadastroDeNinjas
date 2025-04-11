package dev.java10x.CadastroDeNinjas.interfaces;

import dev.java10x.CadastroDeNinjas.models.MissaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissaoRepository extends JpaRepository<MissaoModel, Long> {
}
