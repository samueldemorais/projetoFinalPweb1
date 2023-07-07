package br.edu.ifpb.gugawag.hifpbinterpretes.model.dto;

import jakarta.validation.constraints.NotBlank;


public record CriarAlunoDTO(@NotBlank String nomeCompleto, @NotBlank String matricula, @NotBlank String curso) {
}
