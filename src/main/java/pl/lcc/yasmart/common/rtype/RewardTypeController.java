package pl.lcc.yasmart.common.rtype;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.lcc.yasmart.common.account.AccountService;

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
    Iterable<RewardType> getRewardTypes(){

        System.out.println("get RewardTypes: ");
        return rtService.getAllRT(accountService.getAccountId());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    RewardType AddRewardType(@RequestBody RewardType newRT){
        return rtService.AddRT(accountService.getDetails(), newRT);
    }

    @DeleteMapping("/{rewardTypeName}")
    @ResponseStatus(HttpStatus.OK)
    void deleteRewardType(@PathVariable String rewardTypeName){
        rtService.deleteRT(accountService.getAccountId(), rewardTypeName);
    }

    @PutMapping("/{rewardTypeName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    RewardType changeRewardType(@RequestBody RewardType newRT, @PathVariable String rewardTypeName){
        return rtService.changeRT(accountService.getAccountId(), rewardTypeName, newRT);
    }

}
