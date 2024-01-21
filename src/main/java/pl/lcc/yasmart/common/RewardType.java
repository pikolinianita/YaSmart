package pl.lcc.yasmart.common;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RewardType {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String iconName;

    private String colorHex;

    @ManyToOne
    private Account owner;

}
