package pl.lcc.yasmart.common.account;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.time.LocalDateTime;
import java.util.UUID;


@Slf4j
@Service
@SessionScope
@Primary
@Profile("!prod")
public class DevAccountService implements AccountService{

    private final Account account;

    private final AccountRepository accountRepository;

    public DevAccountService(AccountRepository accountRepository) {
        log.info("Alternative User Management");
        this.accountRepository=accountRepository;
        account = accountRepository.findByName("user");
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
