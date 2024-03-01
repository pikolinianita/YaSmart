package pl.lcc.yasmart.entity;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.lcc.yasmart.common.account.Account;

import java.util.List;

@Service
public class CampaignService {
    private final CampaignRepository campaignRepo;

    public CampaignService(CampaignRepository campaignRepo) {
        this.campaignRepo = campaignRepo;
    }

    @Transactional
    public Campaign createCampaign(Account details) {
    return new Campaign();

    }

    public List<Campaign> getAllCampaigns(Account details) {
        return campaignRepo.findAllByOwner(details);
    }
}
