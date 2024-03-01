package pl.lcc.yasmart.common.tag;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.lcc.yasmart.common.account.Account;

import java.util.UUID;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    String text;

    @JsonBackReference
    @ManyToOne
    Account owner;
}
