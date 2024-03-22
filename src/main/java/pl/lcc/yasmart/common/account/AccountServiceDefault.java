package pl.lcc.yasmart.common.account;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.UUID;

import static pl.lcc.yasmart.exceptions.WebExceptions.HackerException;

@Service
@SessionScope
@Slf4j
@Profile("prod")
//@Primary
public class AccountServiceDefault implements AccountService {

    private final AccountRepository accountRepository;
    private final Account accountDetails;

    public AccountServiceDefault(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        var auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
           log.atInfo().setMessage("Created Account Service for: {}").addArgument(auth.getName()).log();
            accountDetails = this.accountRepository.findByName(auth.getName());
        } else {
            log.atWarn().setMessage("Created Empty Account Service!!!").log();
            accountDetails = null;
        }
    }

   @Override
   public Account getDetails(){
       return  verified(accountDetails);
    }

    @Override
    public UUID getAccountId(){
        return verified(accountDetails).getId();
    }

    @Override
    public String getAccountName() {
        return verified(accountDetails).getName();
    }

    private Account verified(Account account) throws HackerException {
        if (account == null){
            throw new HackerException("No Account Details available");
        }
        return account;
    }
}
