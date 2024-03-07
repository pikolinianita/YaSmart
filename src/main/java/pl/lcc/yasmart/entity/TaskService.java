package pl.lcc.yasmart.entity;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lcc.yasmart.common.account.Account;
import pl.lcc.yasmart.common.flow.TaskState;
import pl.lcc.yasmart.common.tag.Tag;
import pl.lcc.yasmart.common.tag.TagRepository;
import pl.lcc.yasmart.exceptions.WebExceptions;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TaskService {
    TaskRepository taskRepository;

    TagRepository tagRepository;

    @Autowired
    EntityManager em;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task getTask(Account details, UUID taskID) {
        return taskRepository.fetchOne(taskID)
                .orElseThrow(() -> new WebExceptions.TaskNotFoundException(taskID.toString()));
    }

    public Task createTask(UUID sprintId, TaskCreateDTO dto, Account details) {

        var sprint = em.getReference(Sprint.class, sprintId);

        var task = new Task(null, dto.name(), dto.description(), LocalDateTime.now(),
                null,
                TaskState.NOT_DONE,
                null,null,
                sprint, details);

        taskRepository.save(task);
        return task;
    }
}
