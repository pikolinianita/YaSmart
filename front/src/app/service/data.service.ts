import { Injectable } from '@angular/core';
import { ConnectisService } from './connectis.service';
import { RewardType } from '../domain/reward-type';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private connectisService: ConnectisService) { }

  public getRewardTypes() :RewardType[]{ 
      return this.connectisService.getRewardTypes();
  }

  public deleteRewardType(reward:string ) :void{
    this.connectisService.deleteRewardType(reward);
  };

}
