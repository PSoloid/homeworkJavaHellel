package com.Hellel.PSoloid.dao.factory;



import com.Hellel.PSoloid.dao.businessobjects.Account;

import java.util.Collection;

/**
 * Created by VSulevskiy on 14.09.2015.
 */
public interface AccountDao {
    boolean insertAccount(Account account);
    boolean deleteAccount(Account account);
    Account findAccount(long id);
    boolean updateAccount(Account account);
    Collection<Account> getAccounts();
}
