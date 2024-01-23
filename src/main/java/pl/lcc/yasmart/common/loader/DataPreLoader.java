package pl.lcc.yasmart.common.loader;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.lcc.yasmart.common.account.Account;
import pl.lcc.yasmart.common.account.AccountRepository;
import pl.lcc.yasmart.common.rtype.RewardType;
import pl.lcc.yasmart.common.rtype.RewardTypeRepository;
import pl.lcc.yasmart.common.tag.Tag;
import pl.lcc.yasmart.common.tag.TagRepository;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Component
@AllArgsConstructor
public class DataPreLoader implements CommandLineRunner {

    private AccountRepository accountRepository;

    private RewardTypeRepository rtRepository;

    private TagRepository tagRepository;

    @Override
    public void run(String... args) throws Exception {
       var user = addMember();
       var rewardTypeMap = addRewardType(user);
       var tagMap = addTags(user);
    }

    private Account addMember() {
       var user = new Account();
       user.setName("user");
       user.setEmail("user@web.com");
       user.setCreated(LocalDateTime.of(2000, 3, 14, 14, 15));
       user.setBio("Very Nice User, Love Pizza And Pasta");
       accountRepository.save(user);
       return user;
    }

    private Map<String, RewardType> addRewardType(Account user){
        var map = Map.of(
                "Cash", new RewardType(UUID.randomUUID(), "Cash", "monetization_on","#FFD700", user),
                "Pizza", new RewardType(UUID.randomUUID(), "Pizza", "local_pizza", "#FF0000", user));
        rtRepository.saveAll(map.values());
        return map;
    }

    private Map<String, Tag> addTags(Account user) {
        var map = Map.of(
                "It", new Tag(null, "It", user),
                "Book", new Tag(null, "Book", user)
        );
        tagRepository.saveAll(map.values());
        return map;
    }

    public DataPreLoader clean(){

        tagRepository.deleteAll();
        rtRepository.deleteAll();
        accountRepository.deleteAll();
        return this;
    }

}
