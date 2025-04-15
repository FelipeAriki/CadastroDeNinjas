package dev.java10x.CadastroDeNinjas.service;

import dev.java10x.CadastroDeNinjas.DTOs.NinjaDTO;
import dev.java10x.CadastroDeNinjas.interfaces.NinjaRepository;
import dev.java10x.CadastroDeNinjas.mappers.NinjaMapper;
import dev.java10x.CadastroDeNinjas.models.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {
    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper){
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public List<NinjaDTO> obterNinjas(){
        List<NinjaModel> ninjas = this.ninjaRepository.findAll();
        return ninjas.stream()
                .map(this.ninjaMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    public NinjaDTO obterNinja(Long id){
        Optional<NinjaModel> ninjaObtido = this.ninjaRepository.findById(id);
        return ninjaObtido.map(this.ninjaMapper::mapToDTO).orElse(null);
    }

    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.mapToEntity(ninjaDTO);
        ninja = this.ninjaRepository.save(ninja);
        return this.ninjaMapper.mapToDTO(ninja);
    }

    public NinjaDTO alterarNinja(Long id, NinjaDTO ninjaDTO){
        Optional<NinjaModel> ninjaExistente = this.ninjaRepository.findById(id);
        if(ninjaExistente.isPresent()){
            NinjaModel ninjaAtualizado = this.ninjaMapper.mapToEntity(ninjaDTO);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = this.ninjaRepository.save(ninjaAtualizado);
            return this.ninjaMapper.mapToDTO(ninjaSalvo);
        }
        return null;
    }

    public void deletarNinja(Long id){
        this.ninjaRepository.deleteById(id);
    }
}
