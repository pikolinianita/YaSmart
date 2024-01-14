package pl.lcc.yasmart.dev;

import org.springframework.web.bind.annotation.*;
import pl.lcc.yasmart.domain.RewardType;
import pl.lcc.yasmart.service.RewardService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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
        System.out.println("Inside Get");
        return rewardService.getList();
    }

    @PostMapping(value = "/list", consumes = "application/json")
    String addRewardType(@RequestBody RewardType rewardType){
        System.out.println("Inside Post");
        rewardService.addItem(rewardType);
        return "ok";
    }

}
