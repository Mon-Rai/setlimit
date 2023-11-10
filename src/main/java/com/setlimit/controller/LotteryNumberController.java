package com.setlimit.controller;

import com.setlimit.payload.LotteryNumberDto;
import com.setlimit.service.LotteryNumberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lottery")
public class LotteryNumberController {

    private LotteryNumberService lotteryNumberService;

    public LotteryNumberController(LotteryNumberService lotteryNumberService) {
        this.lotteryNumberService = lotteryNumberService;
    }


    @PostMapping("/number")
    public ResponseEntity<LotteryNumberDto> saveNumber(@RequestBody LotteryNumberDto lotteryNumberDto) {
        LotteryNumberDto lotteryNumberDto1 = lotteryNumberService.enterNumber(lotteryNumberDto);
        return new ResponseEntity<>(lotteryNumberDto1, HttpStatus.CREATED);
    }



    @PostMapping("/check-limits")
    public ResponseEntity<List<LotteryNumberDto>> checkLimits(@RequestBody List<Long> numbers) {
        List<LotteryNumberDto> result = lotteryNumberService.checkLimits(numbers);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }




    @PostMapping("/check-limit/{id}")
    public ResponseEntity<LotteryNumberDto> checkLimitById(@PathVariable Long id) {
        LotteryNumberDto result = lotteryNumberService.checkLimitById(id);

        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
