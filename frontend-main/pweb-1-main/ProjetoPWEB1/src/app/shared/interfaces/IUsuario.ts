import { IHorario } from "./IHorario";

export interface IUsuario {
  nome?: string;
  dataNascimento?: Date;
  cpf?: string;
  id?: string;
  email?: string;
  horarios?: IHorario[];
  idade?: number;
}
