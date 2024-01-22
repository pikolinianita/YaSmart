package pl.lcc.yasmart.common.rtype;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RewardTypeRepository extends CrudRepository<RewardType, Long> {
    Iterable<RewardType> findAllByOwner_Id(UUID accountId);

    void deleteByNameAndOwner_Id(String rewardTypeName, UUID userId);
}
