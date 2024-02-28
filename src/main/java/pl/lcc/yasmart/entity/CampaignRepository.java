package pl.lcc.yasmart.entity;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CampaignRepository extends CrudRepository<Campaign, UUID> {
}
