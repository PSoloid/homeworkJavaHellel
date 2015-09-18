package com.Hellel.PSoloid.dao.factory.xml;


import com.Hellel.PSoloid.dao.factory.AccountDao;
import com.Hellel.PSoloid.dao.factory.CustomerDao;
import com.Hellel.PSoloid.dao.factory.DaoFactory;

/**
 * Created by VSulevskiy on 14.09.2015.
 */
public class XmlDaoFactory extends DaoFactory {
    @Override
    public CustomerDao getCustomerDao() {
        return new XmlCustomerDao();
    }

    @Override
    public AccountDao getAccountDao() {
        return new XmlAccountDao();
    }
}
