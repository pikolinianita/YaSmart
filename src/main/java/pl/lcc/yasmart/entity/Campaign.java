package pl.lcc.yasmart.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.NaturalId;
import pl.lcc.yasmart.common.account.Account;
import pl.lcc.yasmart.common.flow.CampaignState;
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
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NaturalId
    private String name;

    private String description;

    private LocalDateTime created;

    private LocalDateTime finished;

    @Enumerated(EnumType.STRING)
    private CampaignState flowState;

    @ManyToMany
    private Set<Tag> tags;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Reward> rewards;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "campaign", cascade = CascadeType.ALL)
    private Set<Project> projects;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Account owner;

    public Campaign addProject(Project project){
        project.setCampaign(this);
        projects.add(project);
        return this;
    }

    public Campaign addTag(Tag tag){
        tags.add(tag);
        return this;
    }

}
