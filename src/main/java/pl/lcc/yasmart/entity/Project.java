package pl.lcc.yasmart.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.NaturalId;
import pl.lcc.yasmart.common.account.Account;
import pl.lcc.yasmart.common.flow.ScenarioState;
import pl.lcc.yasmart.common.reward.Reward;
import pl.lcc.yasmart.common.tag.Tag;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;


@Entity
@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NaturalId
    private String name;

    private String description;

    private LocalDateTime created;

    private LocalDateTime finished;

    @Enumerated(EnumType.STRING)
    ScenarioState scenarioFlow;

    @ManyToMany
    private Set<Tag> tags;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Reward> rewards;

    @ManyToOne(fetch = FetchType.LAZY)
    private Campaign campaign;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "project", cascade = CascadeType.ALL)
    private Set<Task> tasks;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account owner;

    public Project addTask(Task task) {
        task.setProject(this);
        tasks.add(task);
        return this;
    }
    public Project addTag(Tag tag){
        tags.add(tag);
        return this;
    }
}
