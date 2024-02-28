import { Component } from '@angular/core';
import { DataService } from '../../service/data.service';
import { RewardType } from '../../domain/reward-type';

@Component({
  selector: 'app-summary',
  standalone: true,
  imports: [],
  templateUrl: './summary.component.html',
  styleUrl: './summary.component.css'
})
export class SummaryComponent {

  public rewards : RewardType[];

  constructor(private dataService: DataService) {
      this.rewards = dataService.getRewardTypes();
  }

  public deleteOne(reward: string){
      this.dataService.deleteRewardType(reward);
      this.rewards = this.dataService.getRewardTypes();
  }


}
