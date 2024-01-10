import { Icon } from "./icon";

export class Task {
    public id:string;
    public text:string;
    public time:Icon;
    public reward:Icon;

    constructor(id:string, text:string, time:Icon, reward:Icon){
        this.id = id;
        this.text = text;
        this.time = time;
        this.reward = reward;
    }

}
