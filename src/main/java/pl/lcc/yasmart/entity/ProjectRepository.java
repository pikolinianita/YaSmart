package pl.lcc.yasmart.entity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.lcc.yasmart.common.account.Account;

import java.util.List;
import java.util.UUID;

public interface ProjectRepository extends CrudRepository<Project, UUID> {
    List<Project> findAllByOwner(Account account);

    @Query("""
        SELECT new pl.lcc.yasmart.entity.ProjectSummaryDTO
        (p.id,
        p.name,
        p.state,
        count (t.name),
        -1
       )
        FROM Project p
        JOIN tasks t on t.project = p
        """)
    //(select count(t.name) where t.state='DONE' group by t.name)
    List<ProjectSummaryDTO> getAllProjectsSummary(Account account);
}
