package com.setlimit.repository;

import com.setlimit.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    // You can add custom query methods if needed
}
