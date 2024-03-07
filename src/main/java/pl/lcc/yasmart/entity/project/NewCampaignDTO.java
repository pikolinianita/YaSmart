package pl.lcc.yasmart.entity.project;

import pl.lcc.yasmart.common.reward.Reward;

import java.util.List;
import java.util.UUID;

public record NewCampaignDTO(String name, String desc, List<UUID> tags, List<Reward> rewards) {

}
