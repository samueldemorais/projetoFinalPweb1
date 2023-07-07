package br.edu.ifpb.gugawag.hifpbinterpretes.model.dto;

import br.edu.ifpb.gugawag.hifpbinterpretes.model.Aluno;

import java.util.List;
import java.util.stream.Collectors;

public record AlunoDTO(Long id,
                       String nome,
                       String matricula,
                       String curso,
                       List<HorarioDTO> horarios){
    public AlunoDTO(Aluno aluno) {
        this(aluno.getId(), aluno.getNome(), aluno.getMatricula(), aluno.getCurso(), aluno.getHorarios().stream().map(HorarioDTO::new).collect(Collectors.toList()));
    }
}
