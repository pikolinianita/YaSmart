package pl.lcc.yasmart.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("api/v1/common/rewardTypes")
public class TagRewardTypeController {

    RewardTypeService rtService;

    public TagRewardTypeController(RewardTypeService rtService) {
        this.rtService = rtService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<RewardType> getRewardTypes(Principal principal){
        return rtService.getAllRT(principal);
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
