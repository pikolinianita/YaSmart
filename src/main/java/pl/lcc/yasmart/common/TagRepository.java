package pl.lcc.yasmart.common;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TagRepository extends CrudRepository<Tag, UUID> {
}
