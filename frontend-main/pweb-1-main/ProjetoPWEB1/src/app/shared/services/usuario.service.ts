import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { IUsuario } from "../interfaces/IUsuario";
import { IAluno } from "../interfaces/IAluno";
import { IHorario } from "../interfaces/IHorario";

@Injectable({
  providedIn: "root",
})
export class UsuarioService {
  URL_USUARIOS = "http://localhost:8080/interprete";
  URL_ALUNOS = "http://localhost:8080/aluno";
  URL_HORARIO = "http://localhost:8080/horario";

  constructor(private httpClient: HttpClient) {}

  listar(): Observable<IUsuario[]> {
    return this.httpClient.get<IUsuario[]>(this.URL_USUARIOS);
  }

  listarMaioresDeIdade(): Observable<IUsuario[]> {
    return this.httpClient.get<IUsuario[]>(`${this.URL_USUARIOS}/maiorDeIdade`);
  }

  inserir(usuario: IUsuario): Observable<IUsuario> {
    usuario.cpf = usuario.cpf?.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, '$1.$2.$3-$4');
    return this.httpClient.post<IUsuario>(this.URL_USUARIOS, usuario);
  }

  atualizar(usuario: IUsuario): Observable<IUsuario> {
    return this.httpClient.put<IUsuario>(
      `${this.URL_USUARIOS}/${usuario.id}`,
      usuario
    );
  }

  apagar(id: number): Observable<IUsuario> {
    return this.httpClient.delete<IUsuario>(`${this.URL_USUARIOS}/${id}`);
  }

  pesquisarPorId(id: String): Observable<IUsuario> {
    return this.httpClient.get<IUsuario>(`${this.URL_USUARIOS}/${id}`);
  }
  listarAluno(): Observable<IAluno[]> {
    return this.httpClient.get<IAluno[]>(this.URL_ALUNOS);
  }

  inserirAluno(aluno: IAluno): Observable<IAluno> {
    return this.httpClient.post<IAluno>(this.URL_ALUNOS, aluno);
  }

  atualizarAluno(aluno: IAluno): Observable<IAluno> {
    return this.httpClient.put<IAluno>(`${this.URL_ALUNOS}/${aluno.id}`, aluno);
  }

  apagarAluno(id: number): Observable<IAluno> {
    return this.httpClient.delete<IAluno>(`${this.URL_ALUNOS}/${id}`);
  }

  pesquisarPorIdAluno(id: number): Observable<IAluno> {
    return this.httpClient.get<IAluno>(`${this.URL_ALUNOS}/${id}`);
  }

  pesquisarPorCpf(cpf: string | undefined): Observable<IUsuario[]> {
    return this.httpClient.get<IUsuario[]>(`${this.URL_USUARIOS}?cpf=${cpf}`);
  }

  listarHorarios(): Observable<IHorario[]> {
    return this.httpClient.get<IHorario[]>(`${this.URL_HORARIO}`);
  }
  inserirHorario(horario: IHorario): Observable<IHorario> {
    console.log(horario)
    return this.httpClient.post<IHorario>(this.URL_HORARIO, horario);
  }
  atualizarHorario(horario: IHorario): Observable<IHorario> {
    return this.httpClient.put<IHorario>(`${this.URL_HORARIO}/${horario.id}`, horario);
  }
  apagarHorario(id: number): Observable<IHorario> {
    return this.httpClient.delete<IHorario>(`${this.URL_HORARIO}/${id}`);
  }
}
