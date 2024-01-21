package pl.lcc.yasmart.common;

import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.UUID;

@Service
public class RewardTypeService {

    private final RewardTypeRepository rewardTypeRepository;

    public RewardTypeService(RewardTypeRepository rewardTypeRepository) {
        this.rewardTypeRepository = rewardTypeRepository;
   }

    public Iterable<RewardType> getList(){
        return rewardTypeRepository.findAll();
    }

    public int addItem(RewardType rt){
        rewardTypeRepository.save(rt);
        return 0;
    }

    public Iterable<RewardType> getAllRT(UUID userId) {
        return rewardTypeRepository.findAllByOwner_Id(userId);
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
