package pl.lcc.yasmart.entity.task;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskRepository extends CrudRepository<Task, UUID> {

   // @Query("select t from Task t JOIN FETCH Account a ON t.owner = a")
    @Query("FROM Task t Join Fetch t.owner a")
    List<Task> findListAll();

    @Query("FROM Task t Join Fetch t.owner a WHERE t.id = :id ")
    Optional<Task> fetchOne(UUID id);
}
