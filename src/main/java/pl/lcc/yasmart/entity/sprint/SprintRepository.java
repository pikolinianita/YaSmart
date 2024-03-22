package pl.lcc.yasmart.entity.sprint;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.lcc.yasmart.common.account.Account;

import java.util.List;
import java.util.UUID;

public interface SprintRepository extends CrudRepository<Sprint, UUID> {
    List<Sprint> findAllByOwner(Account account);

    @Query("""
        SELECT new pl.lcc.yasmart.entity.sprint.SprintSummaryDTO
        (s.id, s.name, s.state, count (t.name),
        -1
       )
        FROM Sprint s
        JOIN tasks t ON t.sprint = s
        
        GROUP BY s
        """)
    //, t//where t.state='DONE'
    //(select count(t.name) where t.state='DONE' group by t.name)
    // (select count(t.name) where t.state='DONE' group by t)
    List<SprintSummaryDTO> getAllProjectsSummary(Account account);
}
