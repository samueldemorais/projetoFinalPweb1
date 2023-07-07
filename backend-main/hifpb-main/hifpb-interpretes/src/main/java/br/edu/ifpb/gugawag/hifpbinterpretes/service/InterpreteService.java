package br.edu.ifpb.gugawag.hifpbinterpretes.service;

import br.edu.ifpb.gugawag.hifpbinterpretes.model.Interprete;
import br.edu.ifpb.gugawag.hifpbinterpretes.model.dto.CriarInterpreteDTO;
import br.edu.ifpb.gugawag.hifpbinterpretes.model.dto.InterpreteDTO;
import br.edu.ifpb.gugawag.hifpbinterpretes.repositorio.InterpreteRepositorio;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InterpreteService {

    private final InterpreteRepositorio repositorio;

    public InterpreteService(InterpreteRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Interprete criarInterprete(CriarInterpreteDTO criarInterpreteDTO){
        return repositorio.save(new Interprete(criarInterpreteDTO));
    }

    public Interprete encontrarPorId(Long id){
        return repositorio.findById(id).orElseThrow(()-> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Interprete não encontrado"
        ));
    }

    public List<Interprete> listarInterpretes(){
        return repositorio.findAll();
    }


    public Interprete atualizarInterprete(Long id, CriarInterpreteDTO criarInterpreteDTO) {
        return repositorio.findById(id).map(interprete -> {
            interprete.setNome(criarInterpreteDTO.nomeCompleto());
            interprete.setCpf(criarInterpreteDTO.cpf());
            interprete.setIdade(criarInterpreteDTO.idade());
            interprete.setEmail(criarInterpreteDTO.email());
            return repositorio.save(interprete);
        }).orElseThrow(()-> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Interprete não encontrado"
        ));
    }

    public void deletarInterprete(Long id) {
        repositorio.deleteById(id);
    }

    public List<Interprete> listarInterpretesMaioresDeIdade() {
        return repositorio.findMaioresDe18Anos();
    }
}
