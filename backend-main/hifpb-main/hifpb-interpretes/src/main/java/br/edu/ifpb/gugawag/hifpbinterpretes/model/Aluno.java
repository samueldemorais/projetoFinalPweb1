package br.edu.ifpb.gugawag.hifpbinterpretes.model;

import br.edu.ifpb.gugawag.hifpbinterpretes.model.dto.CriarAlunoDTO;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
 
    private String matricula;

    private String curso;

    @OneToMany(mappedBy="aluno")
    private Set<Horario> horarios = new HashSet<>();

    public Aluno() {
    }

    public Aluno(Long id, String nome, String matricula, String curso, HashSet<Horario> horarios) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
        this.horarios = horarios;
    }

    public Aluno(CriarAlunoDTO alunoDTO) {
        this.nome = alunoDTO.nomeCompleto();
        this.matricula = alunoDTO.matricula();
        this.curso = alunoDTO.curso();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Set<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(HashSet<Horario> horarios) {
        this.horarios = horarios;
    }
}