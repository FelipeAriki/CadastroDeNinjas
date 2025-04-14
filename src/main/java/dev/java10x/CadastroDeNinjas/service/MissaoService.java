package dev.java10x.CadastroDeNinjas.service;

import dev.java10x.CadastroDeNinjas.interfaces.MissaoRepository;
import dev.java10x.CadastroDeNinjas.models.MissaoModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {
    private MissaoRepository missaoRepository;

    MissaoService(MissaoRepository missaoRepository){
        this.missaoRepository = missaoRepository;
    }

    public List<MissaoModel> obterMissoes(){
        return this.missaoRepository.findAll();
    }
    public MissaoModel obterMissao(Long id){
        Optional<MissaoModel> missao = this.missaoRepository.findById(id);
        return missao.orElse(null);
    }

    public MissaoModel criarMissao(MissaoModel missaoModel){
        return this.missaoRepository.save(missaoModel);
    }

    public MissaoModel atualizarMissao(Long id, MissaoModel missaoModel){
        if(this.missaoRepository.existsById(id)){
            missaoModel.setId(id);
            return this.missaoRepository.save(missaoModel);
        }
        return null;
    }

    public void deletarMissao(Long id){
        this.missaoRepository.deleteById(id);
    }
}
