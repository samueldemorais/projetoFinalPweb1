package br.edu.ifpb.gugawag.hifpbinterpretes.controller;

import br.edu.ifpb.gugawag.hifpbinterpretes.model.dto.CriarInterpreteDTO;
import br.edu.ifpb.gugawag.hifpbinterpretes.model.dto.InterpreteDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import br.edu.ifpb.gugawag.hifpbinterpretes.service.InterpreteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/interprete")
public class InterpreteController {
    private final InterpreteService service;

    private InterpreteController (InterpreteService service){
        this.service = service;
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public InterpreteDTO criarInterprete(@RequestBody CriarInterpreteDTO criarInterpreteDTO){
        return new InterpreteDTO(service.criarInterprete(criarInterpreteDTO));
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public InterpreteDTO buscarInterprete(@PathVariable Long id){
        return new InterpreteDTO(service.encontrarPorId(id));
    }

    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<InterpreteDTO> listarInterpretes(){
        return service.listarInterpretes().stream().map(InterpreteDTO::new).collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public InterpreteDTO atualizarInterprete(@PathVariable Long id, @RequestBody CriarInterpreteDTO criarInterpreteDTO){
        return new InterpreteDTO(service.atualizarInterprete(id, criarInterpreteDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarInterprete(@PathVariable Long id){
        service.deletarInterprete(id);
    }

    @GetMapping("/maiorDeIdade")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<InterpreteDTO> listarInterpretesMaioresDeIdade(){
        return service.listarInterpretesMaioresDeIdade().stream().map(InterpreteDTO::new).collect(Collectors.toList());
    }
}
