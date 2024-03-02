package pl.lcc.yasmart.common.rtype;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.lcc.yasmart.common.account.Account;

import java.util.NoSuchElementException;
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
    public RewardType addRT(Account details, RewardType newRT) {
        newRT.setOwner(details);
        rewardTypeRepository.save(newRT);
        return newRT;
    }


    @Transactional
    public void deleteRT(UUID userId, UUID rewardTypeID) {
        rewardTypeRepository.deleteByIdAndOwner_Id(rewardTypeID, userId);
    }

    @Transactional
    public RewardType changeRT(UUID userId, String rewardTypeName, RewardType newRT) {
        RewardType rewardType = rewardTypeRepository.findByNameAndOwner_Id(rewardTypeName, userId)
                .orElseThrow(() -> new NoSuchElementException("No element with name: " + rewardTypeName));
        rewardType.setName(newRT.getName());
        rewardType.setColorHex(newRT.getColorHex());
        rewardType.setIconName(newRT.getIconName());
        return rewardType;
    }
}
