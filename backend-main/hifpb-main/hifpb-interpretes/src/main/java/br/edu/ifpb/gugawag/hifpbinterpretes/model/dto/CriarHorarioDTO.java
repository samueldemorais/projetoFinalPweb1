package br.edu.ifpb.gugawag.hifpbinterpretes.model.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;


public record CriarHorarioDTO(@NotNull LocalDate data, @NotNull LocalTime hora, @NotNull Long interpreteId, @NotNull Long alunoId) {
}
