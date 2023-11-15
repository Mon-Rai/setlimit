package com.setlimit.service.impl;

import com.setlimit.entity.TransactionEntity;
import com.setlimit.payload.TransactionDTO;
import com.setlimit.repository.TransactionRepository;
import com.setlimit.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public TransactionDTO saveTransaction(TransactionDTO transactionDTO) {
        TransactionEntity entity = new TransactionEntity();
        entity.setNumbers(transactionDTO.getNumbers());
        entity.setName(transactionDTO.getName());
        entity.setMobile(transactionDTO.getMobile());
        entity.setAmount(transactionDTO.getAmount());

        TransactionEntity savedEntity = transactionRepository.save(entity);

        return convertEntityToDTO(savedEntity);
    }

    @Override
    public List<TransactionDTO> getAllTransactions() {
        List<TransactionEntity> entities = transactionRepository.findAll();
        return entities.stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    private TransactionDTO convertEntityToDTO(TransactionEntity entity) {
        TransactionDTO dto = new TransactionDTO();
        dto.setNumbers(entity.getNumbers());
        dto.setName(entity.getName());
        dto.setMobile(entity.getMobile());
        dto.setAmount(entity.getAmount());
        return dto;
    }
}
