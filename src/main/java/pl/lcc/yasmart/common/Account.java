package pl.lcc.yasmart.common;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import java.time.LocalDateTime;
import java.util.UUID;

//Password and such are managed by Security somewhere
@Entity
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @NaturalId
    String name;

    @NaturalId
    String email;

    String bio;

    LocalDateTime created;

}
