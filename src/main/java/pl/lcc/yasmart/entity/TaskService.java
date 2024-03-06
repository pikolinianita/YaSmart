package pl.lcc.yasmart.entity;

import org.springframework.stereotype.Service;

@Service
public class TaskService {
    TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
}
