package pl.lcc.yasmart.common;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RewardTypeRepository extends CrudRepository<RewardType, Long> {
    Iterable<RewardType> findAllByOwner_Id(UUID accountId);
}
