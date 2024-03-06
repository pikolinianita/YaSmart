package pl.lcc.yasmart.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lcc.yasmart.common.account.AccountService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/sprints")
public class SprintController {

    private final AccountService accountService;

    private final SprintService sprintService;

    public SprintController(AccountService accountService, SprintService sprintService) {
        this.accountService = accountService;
        this.sprintService = sprintService;
    }

    @GetMapping
    public List<Sprint> getAllProjects(){
        log.info("Get All in projects");
        return sprintService.getAllProjects(accountService.getDetails());
    }

    @GetMapping("/summary")
    public List<SprintSummaryDTO> getAllProjectsSummmary(){
        log.info("Get All in projects");
        return sprintService.getAllProjectsSummary(accountService.getDetails());
    }


    public Sprint getOneProject(){
        throw new RuntimeException("Not Implemented Yet");
    }

    public Sprint deleteProject(){
        throw new RuntimeException("Not Implemented Yet");
    }

    public Sprint createProject(){
        throw new RuntimeException("Not Implemented Yet");
    }

    public Sprint modifyProject(){
        throw new RuntimeException("Not Implemented Yet");
    }

}
