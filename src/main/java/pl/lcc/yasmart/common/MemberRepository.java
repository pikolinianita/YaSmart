package pl.lcc.yasmart.common;

import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
    Member findByName(String name);
}
