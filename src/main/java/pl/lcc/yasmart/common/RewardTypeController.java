package pl.lcc.yasmart.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("api/v1/common/rewardTypes")
public class RewardTypeController {

    private final AccountService accountService;
    private final RewardTypeService rtService;

    public RewardTypeController(RewardTypeService rtService, AccountService accountService) {
        this.rtService = rtService;
        this.accountService = accountService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Iterable<RewardType> getRewardTypes(Principal principal){

        System.out.println("get RT: " + principal);
        return rtService.getAllRT(accountService.getAccountId());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    RewardType AddRewardType(Principal principal, @RequestBody RewardType newRT){
        return rtService.AddRT(principal, newRT);
    }

    @DeleteMapping("/{rewardTypeName}")
    @ResponseStatus(HttpStatus.OK)
    void deleteRewardType(Principal principal, @PathVariable String rewardTypeName){
        rtService.deleteRT(principal, rewardTypeName);
    }

    @PutMapping("/{rewardTypeName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    RewardType changeRewardType(Principal principal, @RequestBody RewardType newRT){
        return rtService.changeRT(principal, newRT);
    }

}
