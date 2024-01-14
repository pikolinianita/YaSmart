import { Injectable } from '@angular/core';
import { RewardType } from '../domain/reward-type';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ConnectisService {
  
  constructor(private httpClient: HttpClient) { 
    console.log("ConnectisService constructor");
  
  }

  getRewardTypes(): RewardType[] {
    console.log("conn Get Rewards");
    this.httpClient.get<GHUser>("https://api.github.com/users/pikolinianita")
      .subscribe(data=> {
        console.log("Oto GH2");
        console.log( JSON.stringify(data))
        console.log(data.login);
      });

    return [new RewardType("Cash", "monetization_on","#FFD700"), new RewardType("Pizza", "local_pizza", "#FF0000")];
  }
}

class GHUser {
  public login!: string;
  public id!: string;
}