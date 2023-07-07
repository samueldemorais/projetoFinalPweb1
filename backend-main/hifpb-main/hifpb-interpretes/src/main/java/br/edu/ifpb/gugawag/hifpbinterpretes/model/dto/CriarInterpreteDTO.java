package br.edu.ifpb.gugawag.hifpbinterpretes.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CriarInterpreteDTO (@NotBlank String nomeCompleto,
                                  @NotBlank @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}", message = "CPF Inválido! Deve ter 11 dígitos.") String cpf,
                                  @NotBlank Integer idade,
                                  @NotBlank String email){
}
