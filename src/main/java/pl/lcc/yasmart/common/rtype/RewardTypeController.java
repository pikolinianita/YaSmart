package pl.lcc.yasmart.common.rtype;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.lcc.yasmart.common.account.AccountService;

@Slf4j
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
        log.atInfo().setMessage("Get received for: {}" ).addArgument(accountService.getAccountName()).log();
        return rtService.getAllRT(accountService.getAccountId());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    RewardType AddRewardType(@RequestBody RewardType newRT){
        log.atInfo().setMessage("Post received for: {}. Args {}" ).addArgument(accountService.getAccountName()).addArgument(newRT).log();
        return rtService.AddRT(accountService.getDetails(), newRT);
    }

    @DeleteMapping("/{rewardTypeName}")
    @ResponseStatus(HttpStatus.OK)
    void deleteRewardType(@PathVariable String rewardTypeName){
        log.atInfo().setMessage("Delete received for: {}. Args {}" ).addArgument(accountService.getAccountName()).addArgument(rewardTypeName).log();
        rtService.deleteRT(accountService.getAccountId(), rewardTypeName);
    }

    @PutMapping("/{rewardTypeName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void changeRewardType(@RequestBody RewardType newRT, @PathVariable String rewardTypeName){
        log.atInfo().setMessage("Put received for: {}. Args {} : {}" ).addArgument(accountService.getAccountName()).addArgument(rewardTypeName).addArgument(newRT).log();
        rtService.changeRT(accountService.getAccountId(), rewardTypeName, newRT);
    }

}
