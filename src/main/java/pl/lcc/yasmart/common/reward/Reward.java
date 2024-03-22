package pl.lcc.yasmart.common.reward;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.lcc.yasmart.common.rtype.RewardType;


import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reward {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    Integer amount;

    @ManyToOne
    RewardType type;

    private LocalDateTime created;

    private LocalDateTime collected;

}
