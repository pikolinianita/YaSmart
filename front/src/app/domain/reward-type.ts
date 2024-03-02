export class RewardType {

    constructor(public id: string|null, public name: string, public iconName:string, public colorHex: string) {
        this.name = name;
        this.iconName = iconName;
        this.colorHex = colorHex;
        this.id = id;
    }
}
