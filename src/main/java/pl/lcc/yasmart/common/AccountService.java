package pl.lcc.yasmart.common;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.UUID;

import static pl.lcc.yasmart.exceptions.WebExceptions.*;

@Component
@SessionScope
public class AccountService {

    private final AccountRepository accountRepository;
    private final Account accountDetails;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        var auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            System.out.println("Here Principal: " + auth.getName());
            accountDetails = this.accountRepository.findByName(auth.getName());
        } else {
            accountDetails = null;
        }
    }

   public Account getDetails(){
       return  verified(accountDetails);
    }

    public UUID getAccountId(){
        return verified(accountDetails).getId();

    }  private Account verified(Account account) throws HackerException {
        if (account == null){
            throw new HackerException("No Account Details available");
        }
        return account;
    }
}
