package pl.lcc.yasmart.common.loader;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.lcc.yasmart.common.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class DataPreLoader implements CommandLineRunner {

    private MemberRepository memberRepository;

    private RewardTypeRepository rtRepository;

    private TagRepository tagRepository;

    @Override
    public void run(String... args) throws Exception {
       var user = addMember();
        addRewardType(user);
         addTags(user);
    }

    private Member addMember() {
       var user = new Member();
       user.setName("user");
       user.setEmail("user@web.com");
       user.setCreated(LocalDateTime.of(2000, 3, 14, 14, 15));
       user.setBio("Very Nice User, Love Pizza And Pasta");
       memberRepository.save(user);
       return user;
    }

    private List<RewardType> addRewardType(Member user){
        var list = List.of(
                new RewardType(UUID.randomUUID(), "Cash", "monetization_on","#FFD700", user),
                new RewardType(UUID.randomUUID(), "Pizza", "local_pizza", "#FF0000", user));
        rtRepository.saveAll(list);
        return list;
    }

    private List<Tag> addTags(Member user) {
        var list = List.of(
                new Tag(null, "It", user),
                new Tag(null, "Book", user)
        );
        tagRepository.saveAll(list);
        return list;
    }
}
