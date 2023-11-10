package com.setlimit.repository;

import com.setlimit.entity.LotteryNumber;
import com.setlimit.payload.LotteryNumberDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LotteryNumberRepository extends JpaRepository<LotteryNumber, Long> {

}
