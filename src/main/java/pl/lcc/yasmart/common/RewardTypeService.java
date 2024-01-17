package pl.lcc.yasmart.common;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RewardTypeService {

    private final List<RewardType> rewardTypes;

    public RewardTypeService() {
        this.rewardTypes = new ArrayList<>(20);
        rewardTypes.addAll(List.of(
                new RewardType(UUID.randomUUID(), "Cash", "monetization_on","#FFD700", null),
                new RewardType(UUID.randomUUID(), "Pizza", "local_pizza", "#FF0000", null)));
    }

    public List<RewardType> getList(){
        return List.copyOf(rewardTypes);
    }

    public int addItem(RewardType rt){
        rewardTypes.add(rt);
        return 0;
    }

}
