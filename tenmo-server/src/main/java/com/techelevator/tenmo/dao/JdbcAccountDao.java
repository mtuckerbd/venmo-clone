package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class JdbcAccountDao implements AccountDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account getAccount(int accountId) {
        String sql = "SELECT * FROM account WHERE account_id = ?;";
        SqlRowSet resultSet = jdbcTemplate.queryForRowSet(sql, accountId);

        Account result = new Account();
        if (resultSet.next()) {
            result.setAccountId(resultSet.getInt("account_id"));
            result.setUserId(resultSet.getInt("user_id"));
            result.setBalance(resultSet.getBigDecimal("balance"));
        }

        return result;
    }

    public BigDecimal getBalance(int accountId) {
        String sql = "SELECT balance FROM account WHERE account_id = ?;";
        BigDecimal balance = jdbcTemplate.queryForObject(sql, BigDecimal.class, accountId);

        return balance;
    }

}
