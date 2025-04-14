package dev.java10x.CadastroDeNinjas.service;

import dev.java10x.CadastroDeNinjas.interfaces.NinjaRepository;
import dev.java10x.CadastroDeNinjas.models.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;

    NinjaService(NinjaRepository ninjaRepository){
        this.ninjaRepository = ninjaRepository;
    }

    public List<NinjaModel> obterNinjas(){
        return this.ninjaRepository.findAll();
    }

    public NinjaModel obterNinja(Long id){
        Optional<NinjaModel> ninjaObtido = this.ninjaRepository.findById(id);
        return ninjaObtido.orElse(null);
    }

    public NinjaModel criarNinja(NinjaModel ninja){
        return this.ninjaRepository.save(ninja);
    }

    public NinjaModel alterarNinja(Long id, NinjaModel ninja){
        if(this.ninjaRepository.existsById(id)){
            ninja.setId(id);
            this.ninjaRepository.save(ninja);
        }
        return null;
    }

    public void deletarNinja(Long id){
        this.ninjaRepository.deleteById(id);
    }
}
