package pl.lcc.yasmart.dev;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.lcc.yasmart.domain.RewardType;
import pl.lcc.yasmart.service.RewardService;

import java.util.List;

@RestController
public class PingController {

    private RewardService rewardService;

    public PingController(RewardService rewardService) {
        this.rewardService = rewardService;
    }
    @GetMapping(value = "/string", produces = "application/json")
    String returnString(){
        return "kaczka";
    }

    @GetMapping(value ="/list", produces = "application/json")
    List<RewardType> getList(){
        return rewardService.getList();
    }

    @PostMapping(value = "/list", consumes = "application/json")
    String addRewardType(@RequestBody RewardType rewardType){
        rewardService.addItem(rewardType);
        return "ok";
    }

}
