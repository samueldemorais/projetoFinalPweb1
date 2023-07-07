package br.edu.ifpb.gugawag.hifpbinterpretes.model.dto;

import br.edu.ifpb.gugawag.hifpbinterpretes.model.Interprete;

import java.util.List;
import java.util.stream.Collectors;

public record InterpreteDTO (Long id,
                             String nome,
                             String cpf,
                             Integer idade,
                             String email,
                             List<HorarioDTO> horarios){
    public InterpreteDTO(Interprete interprete) {
        this(interprete.getId(), interprete.getNome(), interprete.getCpf(), interprete.getIdade(), interprete.getEmail(), interprete.getHorarios().stream().map(HorarioDTO::new).collect(Collectors.toList()));
    }
}
