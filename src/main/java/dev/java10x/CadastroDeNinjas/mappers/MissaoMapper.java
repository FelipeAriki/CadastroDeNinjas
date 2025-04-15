package dev.java10x.CadastroDeNinjas.mappers;

import dev.java10x.CadastroDeNinjas.DTOs.MissaoDTO;
import dev.java10x.CadastroDeNinjas.models.MissaoModel;
import dev.java10x.CadastroDeNinjas.models.NinjaModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MissaoMapper {

    public MissaoModel mapToEntity(MissaoDTO missaoDTO){
        MissaoModel missaoModel = new MissaoModel();
        missaoModel.setId(missaoDTO.getId());
        missaoModel.setNome(missaoDTO.getNome());
        missaoModel.setDificuldade(missaoDTO.getDificuldade());
        missaoModel.setNinja(missaoDTO.getNinja());

        return missaoModel;
    }

    public MissaoDTO mapToDTO(MissaoModel missaoModel){
        MissaoDTO missaoDTO = new MissaoDTO();
        missaoDTO.setId(missaoModel.getId());
        missaoDTO.setNome(missaoModel.getNome());
        missaoDTO.setDificuldade(missaoModel.getDificuldade());
        missaoDTO.setNinja(missaoModel.getNinja());

        return missaoDTO;
    }
}
