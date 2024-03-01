package pl.lcc.yasmart.common.account;

import java.util.UUID;

public interface AccountService
{
    Account getDetails();

    UUID getAccountId();

    String getAccountName();
}
