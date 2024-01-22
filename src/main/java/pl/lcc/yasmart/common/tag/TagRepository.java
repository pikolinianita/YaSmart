package pl.lcc.yasmart.common.tag;

import org.springframework.data.repository.CrudRepository;
import pl.lcc.yasmart.common.tag.Tag;

import java.util.UUID;

public interface TagRepository extends CrudRepository<Tag, UUID> {
}
