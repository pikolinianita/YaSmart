package pl.lcc.yasmart.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lcc.yasmart.common.account.AccountService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/campaigns")
public class CampaignController {

    private final AccountService accountService;

    private final CampaignService campaignService;

    public CampaignController(AccountService accountService, CampaignService campaignService) {
        this.accountService = accountService;
        this.campaignService = campaignService;
    }

    @GetMapping
    public List<Campaign> getAllCampaigns(){
        log.info("inside campaignGet");
        return campaignService.getAllCampaigns(accountService.getDetails());
    }

    @PostMapping
    public Campaign createCampaign(NewCampaignDTO campaign){
        log.info("inside campaignPost");
        return campaignService.createCampaign(accountService.getDetails());
    }
}
