import { RewardType } from "./reward-type";

export class Campaign {

    constructor(public name: string, public reward: Reward[]) {
        this.name = name;
        this.reward = reward;
    }
}

class Reward{
    constructor(public amount: number, public type: RewardType) {
        this.amount = amount;
        this.type = type;
    }
}
