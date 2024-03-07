import { Injectable } from '@angular/core';
import { RewardType } from '../domain/reward-type';
import { HttpClient } from '@angular/common/http';
import { Observable,mergeMap } from 'rxjs';
import { Scenario } from '../domain/scenario';

@Injectable({
  providedIn: 'root'
})
export class ConnectisService {

  constructor(private httpClient: HttpClient) {
    console.log("ConnectisService constructor");
  }

  getRewardTypes(): Observable<RewardType[]> {
    return this.httpClient.get<RewardType[]>("http://localhost:8080/api/v1/common/rewardTypes");
  }

  deleteRewardType(uuid: string): Observable<RewardType[]> {
    console.log("will delete : " + uuid);
    return this.httpClient.delete<void>("http://localhost:8080/api/v1/common/rewardTypes/" + uuid)
      .pipe(mergeMap(response => this.getRewardTypes()));
  }

  createRewardType(rt:RewardType): Observable<RewardType[]> {   
    console.log("will create : " + JSON.stringify(rt));
    return this.httpClient.post<RewardType[]>("http://localhost:8080/api/v1/common/rewardTypes",rt)
      .pipe(mergeMap(response => this.getRewardTypes()));
  }

  getScenarionsForBoard(): Observable<Scenario[]>{
    return this.httpClient.get<Scenario[]>("http://localhost:8080/api/v1/sprints");
  }

}
class GHUser {
  public login!: string;
  public id!: string;
}