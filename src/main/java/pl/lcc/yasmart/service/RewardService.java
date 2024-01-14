package pl.lcc.yasmart.service;

import org.springframework.stereotype.Service;
import pl.lcc.yasmart.domain.RewardType;

import java.util.ArrayList;
import java.util.List;

@Service
public class RewardService {

    private final List<RewardType> rewardTypes;

    public RewardService() {
        this.rewardTypes = new ArrayList<>(20);
        rewardTypes.addAll(List.of(
                new RewardType("Cash", "monetization_on","#FFD700"),
                new RewardType("Pizza", "local_pizza", "#FF0000")));
    }

    public List<RewardType> getList(){
        return List.copyOf(rewardTypes);
    }

    public int addItem(RewardType rt){
        rewardTypes.add(rt);
        return 0;
    }

}
