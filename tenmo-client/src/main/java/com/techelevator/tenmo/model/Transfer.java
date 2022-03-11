package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Transfer {
    private int transferId;
    private int transferType;
    private int statusId;
    private int transferFromId;
    private int transferToId;
    private BigDecimal transferAmount;

    public Transfer() {
    }

    public Transfer(int transferId, int transferType, int statusId, int transferFromId, int transferToId, BigDecimal transferAmount) {
        this.transferId = transferId;
        this.transferType = transferType;
        this.statusId = statusId;
        this. transferFromId = transferFromId;
        this. transferToId = transferToId;
        this.transferAmount = transferAmount;
    }

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
