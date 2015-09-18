package com.Hellel.PSoloid.dao.factory.postgres;


import com.Hellel.PSoloid.dao.factory.AccountDao;
import com.Hellel.PSoloid.dao.factory.CustomerDao;
import com.Hellel.PSoloid.dao.factory.DaoFactory;

/**
 * Created by VSulevskiy on 14.09.2015.
 */
public class DbDaoFactory extends DaoFactory {
    @Override
    public CustomerDao getCustomerDao() {
        return new DbCustomerDao();
    }

    @Override
    public AccountDao getAccountDao() {
        return new DbAccountDao();
    }
}
