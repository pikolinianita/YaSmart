package pl.lcc.yasmart.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lcc.yasmart.common.account.AccountService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/projects")
public class ProjectController {

    private final AccountService accountService;

    private final ProjectService projectService;

    public ProjectController(AccountService accountService, ProjectService projectService) {
        this.accountService = accountService;
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getAllProjects(){
        log.info("Get All in projects");
        return projectService.getAllProjects(accountService.getDetails());
    }

    @GetMapping("/summary")
    public List<ProjectSummaryDTO> getAllProjectsSummmary(){
        log.info("Get All in projects");
        return projectService.getAllProjectsSummary(accountService.getDetails());
    }


    public Project getOneProject(){
        throw new RuntimeException("Not Implemented Yet");
    }

    public Project deleteProject(){
        throw new RuntimeException("Not Implemented Yet");
    }

    public Project createProject(){
        throw new RuntimeException("Not Implemented Yet");
    }

    public Project modifyProject(){
        throw new RuntimeException("Not Implemented Yet");
    }

}
