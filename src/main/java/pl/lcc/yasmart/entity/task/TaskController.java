package pl.lcc.yasmart.entity.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.lcc.yasmart.common.account.AccountService;

import java.util.UUID;

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

    @GetMapping("/{sprintId}")
    public Task getTask(@PathVariable UUID sprintId)
    {
        return taskService.getTask(accountService.getDetails(), sprintId);
    }

    @DeleteMapping("/{id}")
    public Task deleteTask(){
        throw new RuntimeException("Not Implemented Yet");
    }

    @PostMapping("/{sprintId}")
    public Task createTask(@PathVariable UUID sprintId, @RequestBody TaskCreateDTO task){
        log.info("Create Task: " + task.name());
        return taskService.createTask(sprintId, task, accountService.getDetails());
    }

    public Task modifyTask(){
        throw new RuntimeException("Not Implemented Yet");
    }

}
