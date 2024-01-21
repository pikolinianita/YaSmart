package pl.lcc.yasmart.common;

import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class RewardTypeService {

   // private final List<RewardType> rewardTypes;

    private final RewardTypeRepository rewardTypeRepository;

    public RewardTypeService(RewardTypeRepository rewardTypeRepository) {
        this.rewardTypeRepository = rewardTypeRepository;
//        this.rewardTypes = new ArrayList<>(20);
//        rewardTypes.addAll(List.of(
//                new RewardType(UUID.randomUUID(), "Cash", "monetization_on","#FFD700", null),
//                new RewardType(UUID.randomUUID(), "Pizza", "local_pizza", "#FF0000", null)));
   }

    public Iterable<RewardType> getList(){
        return rewardTypeRepository.findAll();

    }

    public int addItem(RewardType rt){
        rewardTypeRepository.save(rt);
        return 0;
    }

    public List<RewardType> getAllRT(Principal principal) {
        throw new RuntimeException("not Implemented Y2et");
    }

    public RewardType AddRT(Principal principal, RewardType newRT) {
        throw new RuntimeException("not Implemented Y2et");
    }

    public void deleteRT(Principal principal, String rewardTypeName) {
        throw new RuntimeException("not Implemented Y2et");
    }

    public RewardType changeRT(Principal principal, RewardType newRT) {
        throw new RuntimeException("not Implemented Y2et");
    }
}
