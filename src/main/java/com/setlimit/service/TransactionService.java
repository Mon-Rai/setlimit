package com.setlimit.service;

import com.setlimit.payload.TransactionDTO;

import java.util.List;

public interface TransactionService {

    TransactionDTO saveTransaction(TransactionDTO transactionDTO);

    List<TransactionDTO> getAllTransactions();
}
