import { Icon } from "./icon";

export class Task {
    public id:string;
    public name:string;
    public time:Icon;
    public reward:Icon;

    constructor(id:string, name:string, time:Icon, reward:Icon){
        this.id = id;
        this.name = name;
        this.time = time;
        this.reward = reward;
        console.log(this);
    }

}
