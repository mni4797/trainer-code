import { IPokemon } from "./Pokemon";

export interface ITrainer {
    id: number,
    name:String,
    totalBadge: number,
    listOfPokemon: IPokemon[]
}