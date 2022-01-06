package com.bank.dao.impl;

import com.bank.dao.Dao;
import com.bank.data.MysqlConnection;
import com.bank.dto.Currency;
import com.bank.entity.Transaction;
import com.bank.entity.User;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class TransactionDao implements Dao<Transaction, Long> {

    private final User user;

    public TransactionDao(User user) {
        this.user = user;
    }


    /**
     * This method can be used like for admin as for user
     *
     * @return list of transactions
     */
    @SneakyThrows
    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = null;
        Connection connection = MysqlConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from transactions where id=?");
        preparedStatement.setLong(1, user.getId());
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            transactions.add(new Transaction(
                    rs.getLong("id"),
                    rs.getDate("timeCreation"),
                    Currency.valueOf(rs.getString("boughtCurrency")),
                    Currency.valueOf(rs.getString("soldCurrency")),
                    rs.getBigDecimal("amount"))
            );
        }
        return transactions;
    }

    /**
     * @param id - transaction id
     * @return - transaction entity
     */
    @SneakyThrows
    @Override
    public Transaction findById(Long id) {

        Connection connection = MysqlConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from transactions where id=?");
        preparedStatement.setLong(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            return Transaction.builder()
                    .id(rs.getLong("id"))
                    .created(rs.getDate("timeCreation"))
                    .buy(Currency.valueOf(rs.getString("boughtCurrency")))
                    .sell(Currency.valueOf(rs.getString("soldCurrency")))
                    .amount(rs.getBigDecimal("amount"))
                    .build();
        }
        return null;

    }


    /**
     *
     * @param transaction - transaction that inserts into SQL
     * @return - current transaction entity
     */
    @SneakyThrows
    @Override
    public Transaction save(Transaction transaction) {
        Connection connection = MysqlConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into transactions(boughtCurrency, soldCurrency, amount, userId)" +
                " value(?,?,?,?)");
        preparedStatement.setString(1, transaction.getBuy().name());
        preparedStatement.setString(2, transaction.getSell().name());
        preparedStatement.setBigDecimal(3, transaction.getAmount());
        preparedStatement.setLong(4, user.getId());
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            return Transaction.builder()
                    .id(rs.getLong("id"))
                    .created(rs.getDate("timeCreation"))
                    .buy(Currency.valueOf(rs.getString("boughtCurrency")))
                    .sell(Currency.valueOf(rs.getString("soldCurrency")))
                    .amount(rs.getBigDecimal("amount"))
                    .build();
        }
        return null;
    }
}
