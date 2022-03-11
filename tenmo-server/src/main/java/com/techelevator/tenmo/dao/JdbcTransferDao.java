package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.swing.tree.TreeNode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTransferDao implements TransferDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

//    @Override
//    public Transfer createTransfer(Transfer data) {
//        JdbcAccountDao accountDao = new JdbcAccountDao();
//        BigDecimal balance = accountDao.getBalance(data.getTransferFromId());
//        String sql = "INSERT INTO transfer (transfer_type_id, transfer_status_id, account_from, account_to, amount) VALUES (?, ?, ?, ?, ?) RETURNING transfer_id;";
//        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, data.getTransferType(),data.getStatusId(),
//                data.getTransferFromId(), data.getTransferToId(), data.getTransferAmount());
//        if (balance.compareTo(data.getTransferAmount()) > 0) {
//            String sql2 = "UPDATE account " +
//                    "SET balance = balance - ? " +
//                    "WHERE account_id = ?;";
//            jdbcTemplate.update(sql2, data.getTransferAmount(), data.getTransferFromId());
//            String sql3 = "UPDATE account " +
//                    "SET balance = balance + ? " +
//                    "WHERE account_id = ?;";
//            jdbcTemplate.update(sql3, data.getTransferAmount(), data.getTransferToId());
//            return getTransfersById(id);
//        } else {
//            return getTransfersById(id);
//        }
//    }

    @Override
    public Transfer createTransfer(Transfer data) {
        String sql = "INSERT INTO transfer (transfer_type_id, transfer_status_id, account_from, account_to, amount) VALUES (?, ?, ?, ?, ?) RETURNING transfer_id;";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, data.getTransferType(),data.getStatusId(),
                data.getTransferFromId(), data.getTransferToId(), data.getTransferAmount());
        String sql2 = "UPDATE account " +
                "SET balance = balance - ? " +
                "WHERE account_id = ?;";
        jdbcTemplate.update(sql2, data.getTransferAmount(), data.getTransferFromId());
        String sql3 = "UPDATE account " +
                "SET balance = balance + ? " +
                "WHERE account_id = ?;";
        jdbcTemplate.update(sql3, data.getTransferAmount(), data.getTransferToId());
        return getTransfersById(id);

    }


    @Override
    public List<Transfer> getAllTransfers() {
        String sql = "SELECT * FROM transfer;";
        SqlRowSet resultSet = jdbcTemplate.queryForRowSet(sql);

        List<Transfer> results = new ArrayList<>();
        while (resultSet.next()) {
            results.add( mapRowToTransfer(resultSet));
        }
        return results;
    }

    @Override
    public Transfer getTransfersById(int transferId) {
        String sql = "SELECT * FROM transfer WHERE transfer_id = ?;";
        SqlRowSet resultSet = jdbcTemplate.queryForRowSet(sql, transferId);

        Transfer result = null;
        if (resultSet.next()) {
            result = mapRowToTransfer(resultSet);
        }
        return result;
    }

    private Transfer mapRowToTransfer(SqlRowSet resultSet) {
        Transfer transfer = new Transfer();
        transfer.setTransferId(resultSet.getInt("transfer_id"));
        transfer.setTransferType(resultSet.getInt("transfer_type_id"));
        transfer.setStatusId(resultSet.getInt("transfer_status_id"));
        transfer.setTransferFromId(resultSet.getInt("account_from"));
        transfer.setTransferToId(resultSet.getInt("account_to"));
        transfer.setTransferAmount(resultSet.getBigDecimal("amount"));
        return transfer;
    }
}
