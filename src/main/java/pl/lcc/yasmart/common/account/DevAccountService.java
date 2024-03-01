package pl.lcc.yasmart.common.account;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.UUID;


@Slf4j
public class DevAccountService implements AccountService{

    private final Account account;

    public DevAccountService() {
        log.info("Alternative User Management");
        account= new Account()
                .setId(UUID.fromString("3e522003-d14c-4f31-9369-cba80e9c705c"))
                .setEmail("ugly@hell.gov")
                .setBio("Ugly as Fiend")
                .setName("user")
                .setCreated(LocalDateTime.now().minusDays(666));
    }

    @Override
    public Account getDetails() {
       return account;
    }

    @Override
    public UUID getAccountId() {
        return account.getId();
    }

    @Override
    public String getAccountName() {
        return account.getName();
    }
}
