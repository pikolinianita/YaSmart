package pl.lcc.yasmart.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.lcc.yasmart.common.account.Account;

import java.util.List;

@Service
@Slf4j
public class ProjectService {

    ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects(Account details) {
            return projectRepository.findAllByOwner(details);
    }

    public List<ProjectSummaryDTO> getAllProjectsSummary(Account details) {
       return  projectRepository.getAllProjectsSummary(details);
    }
}
