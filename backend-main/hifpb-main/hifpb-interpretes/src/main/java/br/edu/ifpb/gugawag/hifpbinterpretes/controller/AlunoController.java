package br.edu.ifpb.gugawag.hifpbinterpretes.controller;

import br.edu.ifpb.gugawag.hifpbinterpretes.model.dto.AlunoDTO;
import br.edu.ifpb.gugawag.hifpbinterpretes.model.dto.CriarAlunoDTO;
import br.edu.ifpb.gugawag.hifpbinterpretes.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
    private final AlunoService service;

    private AlunoController (AlunoService service){
        this.service = service;
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoDTO criarAluno(@RequestBody CriarAlunoDTO criarAlunoDTO){
        return new AlunoDTO(service.criarAluno(criarAlunoDTO));
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public AlunoDTO buscarAluno(@PathVariable Long id){
        return new AlunoDTO(service.encontrarPorId(id));
    }

    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<AlunoDTO> listarAlunos(){
        return service.listarAlunos().stream().map(AlunoDTO::new).collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public AlunoDTO atualizarAluno(@PathVariable Long id, @RequestBody CriarAlunoDTO criarAlunoDTO){
        return new AlunoDTO(service.atualizarAluno(id, criarAlunoDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarAluno(@PathVariable Long id){
        service.deletarAluno(id);
    }
}
