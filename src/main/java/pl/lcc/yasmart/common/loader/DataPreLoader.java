package pl.lcc.yasmart.common.loader;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.lcc.yasmart.common.account.AccountRepository;
import pl.lcc.yasmart.common.rtype.RewardTypeRepository;
import pl.lcc.yasmart.common.tag.TagRepository;
import pl.lcc.yasmart.entity.CampaignRepository;

import static pl.lcc.yasmart.common.loader.TestData.*;

@Component
@AllArgsConstructor
public class DataPreLoader implements CommandLineRunner {

    private AccountRepository accountRepository;

    private RewardTypeRepository rtRepository;

    private TagRepository tagRepository;

    private CampaignRepository campaignRepository;

    @Override
    public void run(String... args) throws Exception {
       var user = addMember("user");
       accountRepository.save(user);
       var rewardTypeMap = addRewardType(user);
       rtRepository.saveAll(rewardTypeMap.values());
       var tags = TestData.allTagsForUser(user);
       tagRepository.saveAll(tags);
       var campaign = addTagRecursively(createBookCampaign(user), tags.iterator().next());
       campaignRepository.save(campaign);
    }

    public DataPreLoader clean(){
        campaignRepository.deleteAll();
        tagRepository.deleteAll();
        rtRepository.deleteAll();
        accountRepository.deleteAll();
        return this;
    }

}
