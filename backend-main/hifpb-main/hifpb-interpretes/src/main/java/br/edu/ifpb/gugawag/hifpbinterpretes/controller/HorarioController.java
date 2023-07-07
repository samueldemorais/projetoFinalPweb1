package br.edu.ifpb.gugawag.hifpbinterpretes.controller;

import br.edu.ifpb.gugawag.hifpbinterpretes.model.dto.CriarHorarioDTO;
import br.edu.ifpb.gugawag.hifpbinterpretes.model.dto.HorarioDTO;
import br.edu.ifpb.gugawag.hifpbinterpretes.service.HorarioService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/horario")
public class HorarioController {
    private final HorarioService service;

    private HorarioController (HorarioService service){
        this.service = service;
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public HorarioDTO criarHorario(@RequestBody CriarHorarioDTO criarHorarioDTO){
        return new HorarioDTO(service.criarHorario(criarHorarioDTO));
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public HorarioDTO buscarHorario(@PathVariable Long id){
        return new HorarioDTO(service.encontrarPorId(id));
    }

    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<HorarioDTO> listarHorarios(){
        return service.listarHorarios().stream().map(HorarioDTO::new).collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public HorarioDTO atualizarHorario(@PathVariable Long id, @RequestBody CriarHorarioDTO criarHorarioDTO){
        return new HorarioDTO(service.atualizarHorario(id, criarHorarioDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarHorario(@PathVariable Long id){
        service.deletarHorario(id);
    }
}
