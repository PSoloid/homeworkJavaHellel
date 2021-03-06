package com.Hellel.PSoloid.dao.factory.postgres;



import com.Hellel.PSoloid.dao.businessobjects.Account;
import com.Hellel.PSoloid.dao.client.App;
import com.Hellel.PSoloid.dao.connectionpool.ConnectPool;
import com.Hellel.PSoloid.dao.factory.AccountDao;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Collection;


public class DbAccountDao implements AccountDao {

    @Override
    public boolean insertAccount(Account account) {
        ConnectPool pool = new ConnectPool();
        Connection con = pool.checkOut();

        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(
                    "INSERT INTO test.account" +
                            "(account_id, balance) VALUES" +
                            "(? , ?)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.setLong(1, account.getId());
            statement.setBigDecimal(2, account.getBalance());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (statement != null) statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pool.checkIn(con);
        return true;
    }

    @Override
    public boolean deleteAccount(Account account) {
        ConnectPool pool = new ConnectPool();
        Connection con = pool.checkOut();

        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(
                    "DELETE FROM test.account" +
                            " WHERE account_id = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.setLong(1, account.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (statement != null) statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pool.checkIn(con);
        return true;
    }

    @Override
    public Account findAccount(long id) {
        String sqlQuery = "SELECT balance FROM test.account" +
                " WHERE account_id = ?";
        ConnectPool pool = new ConnectPool();
        Connection con = pool.checkOut();

        try (PreparedStatement statement = con.prepareStatement(sqlQuery)) {
            statement.setLong(1, id);
            try(ResultSet resultSet = statement.executeQuery()){
                resultSet.next();
                Account account = new Account(id);
                BigDecimal balance = resultSet.getBigDecimal(1);
                account.setBalance(balance);
                pool.checkIn(con);

                return account;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        pool.checkIn(con);
        return null;
    }

    @Override
    public boolean updateAccount(Account account) {
        String sqlQuery = "UPDATE test.account" +
                " SET balance = ?" +
                " WHERE account_id = ?";
        ConnectPool pool = new ConnectPool();
        Connection con = pool.checkOut();

        try (PreparedStatement statement = con.prepareStatement(sqlQuery)) {
            statement.setBigDecimal(1, account.getBalance());
            statement.setLong(2, account.getId());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        pool.checkIn(con);
        return true;
    }

    @Override
    public Collection<Account> getAccounts() {
        throw new UnsupportedOperationException("Please implement");
    }
}
