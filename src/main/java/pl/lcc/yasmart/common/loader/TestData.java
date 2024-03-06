package pl.lcc.yasmart.common.loader;

import pl.lcc.yasmart.common.account.Account;
import pl.lcc.yasmart.common.flow.CampaignState;
import pl.lcc.yasmart.common.flow.ScenarioState;
import pl.lcc.yasmart.common.flow.TaskState;
import pl.lcc.yasmart.common.rtype.RewardType;
import pl.lcc.yasmart.common.tag.Tag;
import pl.lcc.yasmart.entity.Campaign;
import pl.lcc.yasmart.entity.Sprint;
import pl.lcc.yasmart.entity.Task;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TestData {

    private static Map<String, Tag> tagMap() {

        return Map.of(
                "It", new Tag(null, "It", null),
                "Book", new Tag(null, "Book", null));
    }

    private static Map<String, Task> taskMap() {

        return Map.of(
                "Ch01", new Task(null, "Ch01", "First Chapter, Home",
                        LocalDateTime.now().minusDays(2).minusHours(2),
                        LocalDateTime.now().minusDays(2),
                        TaskState.DONE, new HashSet<>(), new HashSet<>(), null, null),
                "Ch02", new Task(null, "Ch02", "Second Chapter, Journey",
                        LocalDateTime.now().minusDays(1).minusHours(2),
                        null,
                        TaskState.NOT_DONE, new HashSet<>(), new HashSet<>(), null, null),
                "login", new Task(null, "login", "login to project",
                        LocalDateTime.now().minusDays(2).minusHours(2),
                        LocalDateTime.now().minusDays(2),
                        TaskState.DONE, new HashSet<>(), new HashSet<>(), null, null),
                "logout", new Task(null, "logout", "logout page",
                        LocalDateTime.now().minusDays(1).minusHours(2),
                        null,
                        TaskState.NOT_DONE, new HashSet<>(), new HashSet<>(), null, null)
        );
    }

    private static Map<String, Sprint> projectMap() {
        return Map.of(
                "Book", new Sprint(null, "Travel Book", "Short book about Travel",
                        LocalDateTime.now().minusDays(2).minusHours(2), null, ScenarioState.STARTED,
                        new HashSet<>(), new HashSet<>(), null, new HashSet<>(), null));
    }

    private static Map<String, Campaign> campaignMap() {
        return Map.of(
                "Reading", new Campaign(null, "Reading", "Books I want to read",
                        LocalDateTime.now().minusDays(3).minusHours(2), null, CampaignState.STARTED,
                        new HashSet<>(), new HashSet<>(), new HashSet<>(), null)
        );
    }

    static public List<Tag> allTagsForUser(Account user) {
        return tagMap().values().stream()
                .map(tag -> {
                    tag.setOwner(user);
                    return tag;
                })
                .toList();
    }

    static public Campaign createBookCampaign(Account user) {
        return campaignMap().get("Reading").setOwner(user)
                .addProject(projectMap().get("Book").setOwner(user)
                        .addTask(taskMap().get("Ch01").setOwner(user))
                        .addTask(taskMap().get("Ch02").setOwner(user)));
    }

    static public Campaign addTagRecursively(Campaign camp, Tag tag) {
        camp.getSprints().forEach(project -> addTagRecursively(project, tag));
        camp.addTag(tag);
        return camp;
    }

    static public Sprint addTagRecursively(Sprint proj, Tag tag) {
        proj.getTasks().forEach(task -> task.addTag(tag));
        proj.addTag(tag);
        return proj;
    }

    static public Account addMember(String name) {
        var user = new Account();
        user.setName(name);
        user.setEmail(name + "@web.com");
        user.setCreated(LocalDateTime.of(2000, 3, 14, 14, 15));
        user.setBio(user + ": Very Nice User, Love Pizza And Pasta");
        return user;
    }

    static public Map<String, RewardType> addRewardType(Account user){
        return  Map.of(
                "Cash", new RewardType(UUID.randomUUID(), "Cash", "monetization_on","#FFD700", user),
                "Pizza", new RewardType(UUID.randomUUID(), "Pizza", "local_pizza", "#FF0000", user));
    }

}
