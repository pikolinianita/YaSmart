package pl.lcc.yasmart.common.account;

import org.springframework.data.repository.CrudRepository;
import pl.lcc.yasmart.common.account.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {
    Account findByName(String name);
}
