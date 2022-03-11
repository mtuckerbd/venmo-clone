package com.techelevator.tenmo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.ALREADY_REPORTED, reason = "Insufficient Funds")
public class TransferException extends Exception {
    private static final long serialVersionUID = 1L;

    public TransferException() {
        super("Insufficient Funds");
    }
}

