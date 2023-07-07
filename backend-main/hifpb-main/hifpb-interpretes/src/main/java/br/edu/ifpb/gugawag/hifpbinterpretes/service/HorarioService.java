package br.edu.ifpb.gugawag.hifpbinterpretes.service;

import br.edu.ifpb.gugawag.hifpbinterpretes.model.Horario;
import br.edu.ifpb.gugawag.hifpbinterpretes.model.dto.CriarHorarioDTO;
import br.edu.ifpb.gugawag.hifpbinterpretes.repositorio.HorarioRepositorio;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class HorarioService {
    private final HorarioRepositorio repositorio;
    private final AlunoService alunoService;
    private final InterpreteService interpreteService;

    public HorarioService(HorarioRepositorio repositorio, AlunoService alunoService, InterpreteService interpreteService) {
        this.repositorio = repositorio;
        this.alunoService = alunoService;
        this.interpreteService = interpreteService;
    }

    public Horario criarHorario(CriarHorarioDTO criarHorarioDTO){
        var aluno = alunoService.encontrarPorId(criarHorarioDTO.alunoId());
        var interprete = interpreteService.encontrarPorId(criarHorarioDTO.interpreteId());
        return repositorio.save(new Horario(criarHorarioDTO.data(), criarHorarioDTO.hora(), interprete, aluno));
    }

    public Horario encontrarPorId(Long id){
        return repositorio.findById(id).orElseThrow(()-> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Horario não encontrado"
        ));
    }

    public List<Horario> listarHorarios(){
        return repositorio.findAll();
    }

    public Horario atualizarHorario(Long id, CriarHorarioDTO criarHorarioDTO) {
        return repositorio.findById(id).map(horario -> {
            var aluno = alunoService.encontrarPorId(criarHorarioDTO.alunoId());
            var interprete = interpreteService.encontrarPorId(criarHorarioDTO.interpreteId());
            horario.setData(criarHorarioDTO.data());
            horario.setHora(criarHorarioDTO.hora());
            horario.setAluno(aluno);
            horario.setInterprete(interprete);
            return repositorio.save(horario);
        }).orElseThrow(()-> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Horario não encontrado"
        ));
    }

    public void deletarHorario(Long id) {
        repositorio.deleteById(id);
    }
}
