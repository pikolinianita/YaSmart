package pl.lcc.yasmart.common.loader;

import pl.lcc.yasmart.common.account.Account;
import pl.lcc.yasmart.common.tag.Tag;

import java.util.List;
import java.util.Map;

public class TestData {

   private static final Map<String, Tag> tagMap = Map.of(
            "It", new Tag(null, "It", null),
            "Book", new Tag(null, "Book", null));

    static public List<Tag> allTagsForUser(Account user){
       return tagMap.values().stream()
                .map(tag ->{ tag.setOwner(user); return tag;})
                .toList();
    }

}
