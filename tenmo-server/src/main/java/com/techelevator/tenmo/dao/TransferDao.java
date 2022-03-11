package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.exception.TransferException;
import com.techelevator.tenmo.model.Transfer;

import java.util.List;

public interface TransferDao {

    Transfer createTransfer(Transfer data);

    List<Transfer> getAllTransfers();

    Transfer getTransfersById(int transferId);

}
