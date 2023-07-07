package br.edu.ifpb.gugawag.hifpbinterpretes.service;

import br.edu.ifpb.gugawag.hifpbinterpretes.model.Aluno;
import br.edu.ifpb.gugawag.hifpbinterpretes.model.dto.AlunoDTO;
import br.edu.ifpb.gugawag.hifpbinterpretes.model.dto.CriarAlunoDTO;
import br.edu.ifpb.gugawag.hifpbinterpretes.repositorio.AlunoRepositorio;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    private final AlunoRepositorio repositorio;

    public AlunoService(AlunoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Aluno criarAluno(CriarAlunoDTO alunoDTO){
        return repositorio.save(new Aluno(alunoDTO));
    }

    public Aluno encontrarPorId(Long id){
        return repositorio.findById(id).orElseThrow(()-> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Aluno não encontrado"
        ));
    }

    public List<Aluno> listarAlunos(){
        return repositorio.findAll();
    }


    public Aluno atualizarAluno(Long id, CriarAlunoDTO criarAlunoDTO) {
        return repositorio.findById(id).map(aluno -> {
            aluno.setNome(criarAlunoDTO.nomeCompleto());
            aluno.setMatricula(criarAlunoDTO.matricula());
            aluno.setCurso(criarAlunoDTO.curso());
            return repositorio.save(aluno);
        }).orElseThrow(()-> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Aluno não encontrado"
        ));
    }

    public void deletarAluno(Long id) {
        repositorio.deleteById(id);
    }
}
