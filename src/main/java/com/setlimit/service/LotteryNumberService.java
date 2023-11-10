package com.setlimit.service;

import com.setlimit.payload.LotteryNumberDto;

import java.util.List;

public interface LotteryNumberService {

    LotteryNumberDto enterNumber(LotteryNumberDto lotteryNumberDto);

    List<LotteryNumberDto> checkLimits(List<Long> numbers);

    LotteryNumberDto checkLimitById(Long number);

}
