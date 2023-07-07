package br.edu.ifpb.gugawag.hifpbinterpretes.model;

import br.edu.ifpb.gugawag.hifpbinterpretes.model.dto.CriarInterpreteDTO;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Interprete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    private String email;

    private Integer idade;
    
	@OneToMany(mappedBy="interprete", cascade = CascadeType.ALL)
    public Set<Horario> horarios = new HashSet<>();

    public Interprete() {
    }

    public Interprete(Long id, String nome, String cpf, String email, Integer idade, HashSet<Horario> horarios) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.idade = idade;
        this.horarios = horarios;
    }

    public Interprete(CriarInterpreteDTO criarInterpreteDTO) {
        this.nome = criarInterpreteDTO.nomeCompleto();
        this.cpf = criarInterpreteDTO.cpf();
        this.email = criarInterpreteDTO.email();
        this.idade = criarInterpreteDTO.idade();
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Set<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(HashSet<Horario> horarios) {
        this.horarios = horarios;
    }
}