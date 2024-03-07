import { Injectable } from '@angular/core';
import { ConnectisService } from './connectis.service';
import { RewardType } from '../domain/reward-type';
import { Observable } from 'rxjs';
import { Scenario } from '../domain/scenario';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private connectisService: ConnectisService) { }

  public getRewardTypes(): Observable<RewardType[]> {
    return this.connectisService.getRewardTypes();
  }

  public deleteRewardType(reward: string): Observable<RewardType[]> {
    return this.connectisService.deleteRewardType(reward);
  };

  public createRewardType(rt: RewardType): Observable<RewardType[]> {
    return this.connectisService.createRewardType(rt);
  }

  public getScenarionsForBoard(): Observable<Scenario[]>{
    return this.connectisService.getScenarionsForBoard();   
  }
}