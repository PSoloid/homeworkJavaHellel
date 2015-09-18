package com.Hellel.PSoloid.dao.factory.postgres;


import com.Hellel.PSoloid.dao.businessobjects.Account;
import com.Hellel.PSoloid.dao.businessobjects.Customer;
import com.Hellel.PSoloid.dao.client.App;
import com.Hellel.PSoloid.dao.connectionpool.ConnectPool;
import com.Hellel.PSoloid.dao.factory.CustomerDao;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by VSulevskiy on 14.09.2015.
 */
public class DbCustomerDao implements CustomerDao {

    @Override
    public boolean insertCustomer(Customer customer) {

        ConnectPool pool = new ConnectPool();
        Connection con = pool.checkOut();

        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(
                    "INSERT INTO test.customer" +
                            "(customer_id, first_name, last_name) VALUES" +
                            "(? , ? , ?)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.setLong(1, customer.getId());
            statement.setString(2, customer.getFirstName());
            statement.setString(3, customer.getLastName());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Account acc : customer.getAccounts()) {
            try {

                statement = con.prepareStatement(
                        "INSERT INTO test.customer_account" +
                                "(account_id, customer_id) VALUES" +
                                "(? , ?)");
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                statement.setLong(1, acc.getId());
                statement.setLong(2, customer.getId());
                statement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try {
            if (statement != null) statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

       pool.checkIn(con);

        return true;
    }

    @Override
    public boolean deleteCustomer(Customer customer) {
        ConnectPool pool = new ConnectPool();
        Connection con = pool.checkOut();

        PreparedStatement statement = null;

        try {
            statement = con.prepareStatement(
                    "DELETE FROM test.customer" +
                            " WHERE account_id = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.setLong(1, customer.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            statement = con.prepareStatement(
                    "DELETE FROM test.customer_account" +
                            " WHERE customer_id = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.setLong(1, customer.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (statement != null) statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        pool.checkIn(con);

        return true;
    }

    @Override
    public Customer findCustomer(long id) {

        String sqlQuery = "SELECT c.first_name, c.last_name, a.account_id, a.balance " +
                "FROM test.customer c " +
                "INNER JOIN test.customer_account ca ON (c.customer_id = ca.customer_id) " +
                "INNER JOIN test.account a ON (a.account_id = ca.account_id) " +
                "WHERE c.customer_id = ?";

        ConnectPool pool = new ConnectPool();
        Connection con = pool.checkOut();
        try ( PreparedStatement statement = con.prepareStatement(sqlQuery)) {

            statement.setLong(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                resultSet.next();

                Customer customer = new Customer(id);

                String firstName = resultSet.getString(1);
                customer.setFirstName(firstName);

                String lastName = resultSet.getString(2);
                customer.setLastName(lastName);

                List<Account> accounts = new ArrayList<Account>();

                while (resultSet.next()) {

                    long account_id = resultSet.getLong(3);
                    BigDecimal balance = resultSet.getBigDecimal(4);

                    Account account = new Account(account_id, balance);
                    accounts.add(account);
                }
                customer.setAccounts(accounts);

                pool.checkIn(con);
                return customer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pool.checkIn(con);
        return null;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        String sqlQuery = "UPDATE test.customer" +
                " SET first_name = ?," +
                " last_name = ?" +
                " WHERE account_id = ?";

        String sqlQueryInsUni = "INSERT INTO test.customer_account" +
                "(account_id, customer_id) VALUES" +
                "(? , ?)";

        String sqlQueryDel = "DELETE FROM test.customer_account" +
                " WHERE customer_id = ?";

        ConnectPool pool = new ConnectPool();
        Connection con = pool.checkOut();

        try (PreparedStatement statement = con.prepareStatement(sqlQuery)) {
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setLong(3, customer.getId());
            statement.execute();

            PreparedStatement statementDel = con.prepareStatement(sqlQueryDel);
            statementDel.setLong(1, customer.getId());
            statementDel.execute();

            for (Account acc : customer.getAccounts()) {
                PreparedStatement statement1 = con.prepareStatement(sqlQueryInsUni);

                    statement1.setLong(1, acc.getId());
                    statement1.setLong(2, customer.getId());
                    statement1.execute();

                }
            } catch (SQLException e) {
            e.printStackTrace();
        }

        pool.checkIn(con);
        return true;
    }

    @Override
    public Collection<Customer> getCustomers() {

        Collection<Customer> customerCol = new LinkedList<Customer>();


        String sqlQuery = "SELECT c.customer_id, c.first_name, c.last_name, a.account_id, a.balance " +
                "FROM test.customer c " +
                "INNER JOIN test.customer_account ca ON (c.customer_id = ca.customer_id) " +
                "INNER JOIN test.account a ON (a.account_id = ca.account_id) ";

        ConnectPool pool = new ConnectPool();
        Connection con = pool.checkOut();
        try ( PreparedStatement statement = con.prepareStatement(sqlQuery)) {

            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {

                    resultSet.next();

                    Customer customer = new Customer(resultSet.getLong(1));


                    String firstName = resultSet.getString(2);
                    customer.setFirstName(firstName);

                    String lastName = resultSet.getString(3);
                    customer.setLastName(lastName);

                    List<Account> accounts = new ArrayList<Account>();

                    while (resultSet.next()) {
                        if (customer.getId() == resultSet.getLong(1)) {
                            long account_id = resultSet.getLong(4);
                            BigDecimal balance = resultSet.getBigDecimal(5);

                            Account account = new Account(account_id, balance);
                            accounts.add(account);
                        }
                    }
                        customer.setAccounts(accounts);


                    customerCol.add(customer);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pool.checkIn(con);
        return customerCol;

    }
}
