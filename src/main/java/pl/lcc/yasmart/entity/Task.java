package pl.lcc.yasmart.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.NaturalId;
import pl.lcc.yasmart.common.account.Account;
import pl.lcc.yasmart.common.flow.TaskState;
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
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NaturalId
    private String name;

    private String description;

    private LocalDateTime created;

    private LocalDateTime finished;

    @Enumerated(EnumType.STRING)
    private TaskState state;

    @ManyToMany
    private Set<Tag> tags;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Reward> rewards;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Account owner;

    public Task addTag(Tag tag){
        tags.add(tag);
        return this;
    }
}
