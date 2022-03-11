package com.techelevator.tenmo.model;

import com.techelevator.tenmo.dao.JdbcAccountDao;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

public class Transfer {

    private int transferId;
    private int transferType;
    private int statusId;
    @DecimalMin(value = "0.009", message = "You must transfer more that $0.00.")
    private int transferFromId;
    private int transferToId;
    private BigDecimal transferAmount;

    public int getTransferId() {
        return transferId;
    }

    public void setTransferId(int transferId) {
        this.transferId = transferId;
    }

    public int getTransferType() {
        return transferType;
    }

    public void setTransferType(int transferType) {
        this.transferType = transferType;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getTransferFromId() {
        return transferFromId;
    }

    public void setTransferFromId(int transferFromId) {
        this.transferFromId = transferFromId;
    }

    public int getTransferToId() {
        return transferToId;
    }

    public void setTransferToId(int transferToId) {
        this.transferToId = transferToId;
    }

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
    }
}
