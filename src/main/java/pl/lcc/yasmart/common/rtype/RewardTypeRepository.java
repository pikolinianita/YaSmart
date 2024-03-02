package pl.lcc.yasmart.common.rtype;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface RewardTypeRepository extends CrudRepository<RewardType, UUID> {
    Iterable<RewardType> findAllByOwner_Id(UUID accountId);

    void deleteByIdAndOwner_Id(UUID rewardTypeID, UUID userId);

    Optional<RewardType> findByNameAndOwner_Id(String rewardTypeName, UUID userId);

    Optional<RewardType> findByNameAndOwner_Name(String rewardTypeName, String userName);
}
