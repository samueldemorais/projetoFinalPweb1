package br.edu.ifpb.gugawag.hifpbinterpretes.model;

import br.edu.ifpb.gugawag.hifpbinterpretes.model.dto.CriarHorarioDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    private LocalTime hora;

    @ManyToOne
    @JoinColumn(name = "interprete")
    private Interprete interprete;

    @ManyToOne
    @JoinColumn(name = "aluno")
    private Aluno aluno;

    public Horario() {
    }

    public Horario(Long id, LocalDate data, LocalTime hora, Interprete interprete, Aluno aluno) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.interprete = interprete;
        this.aluno = aluno;
    }

    public Horario(LocalDate data, LocalTime hora, Interprete interprete, Aluno aluno) {
        this.data = data;
        this.hora = hora;
        this.interprete = interprete;
        this.aluno = aluno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Interprete getInterprete() {
        return interprete;
    }

    public void setInterprete(Interprete interprete) {
        this.interprete = interprete;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
