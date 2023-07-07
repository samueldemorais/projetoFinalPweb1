import { Component } from "@angular/core";
import { Router } from "@angular/router";
import { IAluno } from "src/app/shared/interfaces/IAluno";
import { IHorario } from "src/app/shared/interfaces/IHorario";
import { IUsuario } from "src/app/shared/interfaces/IUsuario";
import { AlertService } from "src/app/shared/services/alert.service";
import { UsuarioFirestoreService } from "src/app/shared/services/usuario-firestore.service";
import { UsuarioService } from "src/app/shared/services/usuario.service";

@Component({
  selector: "app-cadastrar-horario",
  templateUrl: "./cadastrar-horario.component.html",
  styleUrls: ["./cadastrar-horario.component.css"],
})
export class CadastrarHorarioComponent {
  horario: IHorario;
  usuarios: IUsuario[] = [];
  usuario: IUsuario;
  aluno: IAluno;
  alunos: IAluno[] = [];

  constructor(
    private usuarioService: UsuarioService,
    private roteador: Router,
    private alertService: AlertService
  ) {
    this.horario = {} as IHorario;
    this.usuarios = [] as IUsuario[];
    this.usuario = {} as IUsuario;
    this.aluno = {} as IAluno;
    this.alunos = [] as IAluno[];
  }

  ngOnInit(): void {
    this.usuarioService.listar().subscribe((usuariosRetornados) => {
      console.log(usuariosRetornados);
      this.usuarios = usuariosRetornados;
    });
    this.usuarioService.listarAluno().subscribe((alunosRetornados) => {
      console.log(alunosRetornados);
      this.alunos = alunosRetornados;
    }
    );
  }

  inserir() {
    const userSelected = this.usuarios.filter((usuario) => {
      return usuario.id === this.usuario.id;
    })[0];
    if (this.horario) {
      const valorExistente = userSelected.horarios?.some(
        (horario: IHorario) => {
          return (
            horario.data === this.horario.data &&
            horario.hora === this.horario.hora
          );
        }
      );
      console.log(userSelected.horarios);
      console.log(!!valorExistente);

      if (!!valorExistente) {
        this.alertService.warningAlert("Horário já cadastrado");
        return;
      }
    }
    if (userSelected.horarios) {
      userSelected.horarios.push(this.horario);
    } else {
      userSelected.horarios = [this.horario];
    }
    this.horario.alunoId = this.aluno.id;
    this.horario.interpreteId = this.usuario.id;
    this.usuarioService.inserirHorario(this.horario).subscribe((usuario) => {
      this.roteador.navigate([""]);
    });
  }
}
