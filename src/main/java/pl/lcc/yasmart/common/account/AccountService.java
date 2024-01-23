package pl.lcc.yasmart.common.account;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.UUID;

import static pl.lcc.yasmart.exceptions.WebExceptions.HackerException;

@Component
@SessionScope
@Slf4j
public class AccountService {

    private final AccountRepository accountRepository;
    private final Account accountDetails;

    public AccountService(AccountRepository accountRepository) {
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

   public Account getDetails(){
       return  verified(accountDetails);
    }

    public UUID getAccountId(){
        return verified(accountDetails).getId();
    }

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
