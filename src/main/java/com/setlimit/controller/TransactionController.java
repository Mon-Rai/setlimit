package com.setlimit.controller;

import com.setlimit.payload.TransactionDTO;
import com.setlimit.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/book")
    public TransactionDTO saveTransaction(@RequestBody TransactionDTO transactionDTO) {
        return transactionService.saveTransaction(transactionDTO);
    }

    @GetMapping
    public List<TransactionDTO> getAllTransactions() {
        return transactionService.getAllTransactions();
    }
}
