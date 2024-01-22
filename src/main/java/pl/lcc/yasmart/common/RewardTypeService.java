package pl.lcc.yasmart.common;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

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

    @Transactional
    public RewardType AddRT(Account details, RewardType newRT) {
        newRT.setOwner(details);
        rewardTypeRepository.save(newRT);
        return newRT;
    }


    @Transactional
    public void deleteRT(UUID userId, String rewardTypeName) {
        rewardTypeRepository.deleteByNameAndOwner_Id(rewardTypeName, userId);
    }

    public RewardType changeRT(UUID userId, String rewardTypeName, RewardType newRT) {
        throw new RuntimeException("not Implemented Y2et");
    }
}
