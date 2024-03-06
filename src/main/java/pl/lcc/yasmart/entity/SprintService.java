package pl.lcc.yasmart.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.lcc.yasmart.common.account.Account;
import pl.lcc.yasmart.exceptions.WebExceptions;

import java.util.List;
import java.util.UUID;

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

    public Sprint getProject(Account details, UUID sprintID) {
       var result = sprintRepository.findById(sprintID).orElseThrow( () -> new IllegalArgumentException("Sprint not found"));
       if (details.equals(result.getOwner())){
           return result;
        } else {
           throw new WebExceptions.HackerException("Sprint " + result.getName() + "retrieved for wrong owner!");
        }

    }
}
