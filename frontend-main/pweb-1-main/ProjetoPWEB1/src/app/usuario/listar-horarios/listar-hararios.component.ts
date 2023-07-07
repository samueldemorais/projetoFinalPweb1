
import { ThemePalette } from '@angular/material/core';
import { IHorario } from 'src/app/shared/interfaces/IHorario';
import { UsuarioService } from 'src/app/shared/services/usuario.service';
import { map, Observable } from "rxjs";
import { Component, OnInit } from "@angular/core";

interface Horario {
  horario: string;
  data: string;
  aluno: string;
  interprete: string;
}

@Component({
  selector: 'app-listar-hararios',
  templateUrl: './listar-hararios.component.html',
  styleUrls: ['./listar-hararios.component.css']
})
export class ListarHarariosComponent implements OnInit {
  displayedColumns: string[] = ["hora", "data", "aluno", "interprete"];
  horarios: IHorario[] = [];
  dataSource: IHorario[] = [];
  color: ThemePalette = "accent";
  toggleValue: boolean = false;

  constructor(private usuarioService: UsuarioService) {}

  ngOnInit() {
    this.usuarioService.listarHorarios().subscribe((horarios) => {
      this.dataSource = horarios;
      console.log(this.dataSource);
    });
  }
}
