package br.edu.ifpb.gugawag.hifpbinterpretes.model.dto;

import br.edu.ifpb.gugawag.hifpbinterpretes.model.Horario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonFormat;

public record HorarioDTO(Long id,
                         @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy") LocalDate data,
                         String hora,
                         String aluno,
                         String interprete) {
    public HorarioDTO(Horario horario){
        this(horario.getId(), horario.getData(), horario.getHora().format(DateTimeFormatter.ofPattern("HH:mm")), horario.getAluno().getNome(), horario.getInterprete().getNome());
    }
}
