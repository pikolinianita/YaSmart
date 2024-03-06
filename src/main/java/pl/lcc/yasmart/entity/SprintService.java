package pl.lcc.yasmart.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.lcc.yasmart.common.account.Account;

import java.util.List;

@Service
@Slf4j
public class SprintService {

    SprintRepository sprintRepository;

    public SprintService(SprintRepository sprintRepository) {
        this.sprintRepository = sprintRepository;
    }

    public List<Sprint> getAllProjects(Account details) {
            return sprintRepository.findAllByOwner(details);
    }

    public List<SprintSummaryDTO> getAllProjectsSummary(Account details) {
       return  sprintRepository.getAllProjectsSummary(details);
    }
}
