package pl.lcc.yasmart.dev;

import org.springframework.web.bind.annotation.*;
import pl.lcc.yasmart.common.RewardType;
import pl.lcc.yasmart.common.RewardTypeService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PingController {

    private RewardTypeService rewardTypeService;

    public PingController(RewardTypeService rewardTypeService) {
        this.rewardTypeService = rewardTypeService;
    }
    @GetMapping(value = "/string", produces = "application/json")
    String returnString(){
        return "kaczka";
    }

    @GetMapping(value ="/list", produces = "application/json")
    Iterable<RewardType> getList(){
        System.out.println("Inside Get");
        return rewardTypeService.getList();
    }

    @PostMapping(value = "/list", consumes = "application/json")
    String addRewardType(@RequestBody RewardType rewardType){
        System.out.println("Inside Post");
        rewardTypeService.addItem(rewardType);
        return "ok";
    }

}
