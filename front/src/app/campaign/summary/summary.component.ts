import { Component } from '@angular/core';
import { DataService } from '../../service/data.service';
import { RewardType } from '../../domain/reward-type';
import { RtInputComponent } from "../rt-input/rt-input.component";

@Component({
  selector: 'app-summary',
  standalone: true,
  templateUrl: './summary.component.html',
  styleUrl: './summary.component.css',
  imports: [RtInputComponent]
})
export class SummaryComponent {

  public rewards: RewardType[] = [];

  constructor(private dataService: DataService) {
    dataService.getRewardTypes().subscribe(data => {
      this.rewards = data;
    });
  }

  public deleteOne(reward: string | null) {
    console.log("summ delOne: " + reward);
    if (reward) {
      this.dataService.deleteRewardType(reward).subscribe(data => {
        this.rewards = data;
      });
    }
  }

  public createRewardType(rt: RewardType) {
    console.log(rt);
    this.dataService.createRewardType(rt).subscribe(data => {
      this.rewards = data;
    });
  }
}