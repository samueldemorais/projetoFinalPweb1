import { IHorario } from "./IHorario";

export interface IAluno {
  nome?: string;
  curso?: string;
  matricula?: string;
  id?: string;
  horarios?: IHorario[];
}