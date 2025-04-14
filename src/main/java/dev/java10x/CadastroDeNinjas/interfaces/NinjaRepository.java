package dev.java10x.CadastroDeNinjas.interfaces;

import dev.java10x.CadastroDeNinjas.models.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {
}
