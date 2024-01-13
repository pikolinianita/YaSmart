import { Icon } from "./icon";
import { Task } from "./task";

export class Scenario {
    public name: string;
    public id: string;
    public tasks: Task[];
    public reward: Icon[];
    campaign: string;
    
    constructor(id: string, name: string, campaign:string, tasks: Task[], reward: Icon[]) {
        this.name = name;
        this.id = id;
        this.tasks = tasks;
        this.reward = reward;
        console.log(this);
        this.campaign = campaign;
        
    } 
}
