package pl.lcc.yasmart.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.NaturalId;
import pl.lcc.yasmart.common.account.Account;
import pl.lcc.yasmart.common.reward.Reward;
import pl.lcc.yasmart.common.tag.Tag;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NaturalId
    private String name;

    private String description;

    private LocalDateTime created;

    private LocalDateTime finished;

    @ManyToMany
    Set<Tag> tags;

    @OneToMany(fetch = FetchType.LAZY)
    Set<Reward> rewards;

    @ManyToOne(fetch = FetchType.LAZY)
    Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    Account owner;
}
