package pl.lcc.yasmart.entity.project;

import org.springframework.data.repository.CrudRepository;
import pl.lcc.yasmart.common.account.Account;

import java.util.List;
import java.util.UUID;

public interface CampaignRepository extends CrudRepository<Campaign, UUID> {

    List<Campaign> findAllByOwner(Account owner);
}
