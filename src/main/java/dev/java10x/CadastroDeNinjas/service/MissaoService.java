package dev.java10x.CadastroDeNinjas.service;

import dev.java10x.CadastroDeNinjas.DTOs.MissaoDTO;
import dev.java10x.CadastroDeNinjas.interfaces.MissaoRepository;
import dev.java10x.CadastroDeNinjas.mappers.MissaoMapper;
import dev.java10x.CadastroDeNinjas.models.MissaoModel;
import dev.java10x.CadastroDeNinjas.models.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissaoService {
    private final MissaoRepository missaoRepository;
    private final MissaoMapper missaoMapper;

    MissaoService(MissaoRepository missaoRepository, MissaoMapper missaoMapper){
        this.missaoRepository = missaoRepository;
        this.missaoMapper = missaoMapper;
    }

    public List<MissaoDTO> obterMissoes(){
        List<MissaoModel> missoes = this.missaoRepository.findAll();
        return missoes.stream()
                .map(missaoMapper::mapToDTO)
                .collect(Collectors.toList());
    }
    public MissaoDTO obterMissao(Long id){
        Optional<MissaoModel> missaoObtida = this.missaoRepository.findById(id);
        return missaoObtida.map(this.missaoMapper::mapToDTO).orElse(null);
    }

    public MissaoDTO criarMissao(MissaoDTO missaoDTO){
        MissaoModel missao = missaoMapper.mapToEntity(missaoDTO);
        missao = this.missaoRepository.save(missao);
        return this.missaoMapper.mapToDTO(missao);
    }

    public MissaoDTO atualizarMissao(Long id, MissaoDTO missaoDTO){
        Optional<MissaoModel> missaoExistente = this.missaoRepository.findById(id);
        if(missaoExistente.isPresent()){
            MissaoModel missaoAtualizada = this.missaoMapper.mapToEntity(missaoDTO);
            missaoAtualizada.setId(id);
            MissaoModel missaoSalva = this.missaoRepository.save(missaoAtualizada);
            return this.missaoMapper.mapToDTO(missaoSalva);
        }
        return null;
    }

    public void deletarMissao(Long id){
        this.missaoRepository.deleteById(id);
    }
}
