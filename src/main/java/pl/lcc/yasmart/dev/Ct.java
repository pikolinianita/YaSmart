package pl.lcc.yasmart.dev;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ct {

    @Id
    Long id;

    Long number;
}
