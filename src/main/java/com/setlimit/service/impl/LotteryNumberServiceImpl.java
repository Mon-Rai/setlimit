package com.setlimit.service.impl;

import com.setlimit.entity.LotteryNumber;
import com.setlimit.payload.LotteryNumberDto;
import com.setlimit.repository.LotteryNumberRepository;
import com.setlimit.service.LotteryNumberService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class LotteryNumberServiceImpl implements LotteryNumberService {

    private final LotteryNumberRepository lotteryNumberRepository;

    public LotteryNumberServiceImpl(LotteryNumberRepository lotteryNumberRepository) {
        this.lotteryNumberRepository = lotteryNumberRepository;
    }


    @Override
    public LotteryNumberDto enterNumber(LotteryNumberDto lotteryNumberDto) {
        LotteryNumber lotteryNumber = mapToEntity(lotteryNumberDto);
        LotteryNumber savedNumber = lotteryNumberRepository.save(lotteryNumber);
        return mapToDto(savedNumber);
    }

    @Override
    public LotteryNumberDto checkLimitById(Long number) {
        Optional<LotteryNumber> optionalLotteryNumber = lotteryNumberRepository.findById(number);
        return optionalLotteryNumber.map(this::mapToDto).orElse(null);
    }

    @Override
    public List<LotteryNumberDto> checkLimits(List<Long> numbers) {
        List<LotteryNumberDto> result = new ArrayList<>();
        for (Long number : numbers) {
            Optional<LotteryNumber> optionalLotteryNumber = lotteryNumberRepository.findById(number);
            optionalLotteryNumber.ifPresent(lotteryNumber -> result.add(mapToDto(lotteryNumber)));
        }
        return result;
    }


    @Autowired
    private  ModelMapper mapper;

    private LotteryNumberDto mapToDto(LotteryNumber lotteryNumber) {
        return mapper.map(lotteryNumber, LotteryNumberDto.class);
    }

    private LotteryNumber mapToEntity(LotteryNumberDto lotteryNumberDto) {
        return mapper.map(lotteryNumberDto, LotteryNumber.class);
    }
}
