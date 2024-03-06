package pl.lcc.yasmart.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lcc.yasmart.common.account.AccountService;

@Slf4j
@RestController
@RequestMapping("api/v1/tasks")
public class TaskController {

    private final AccountService accountService;

    private final TaskService taskService;

    public TaskController(AccountService accountService, TaskService taskService) {
        this.accountService = accountService;
        this.taskService = taskService;
    }


}
