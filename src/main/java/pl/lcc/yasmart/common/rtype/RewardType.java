package pl.lcc.yasmart.common.rtype;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.lcc.yasmart.common.account.Account;
import jakarta.validation.constraints.Email;

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
