package com.setlimit.payload;

import lombok.Data;
import lombok.NonNull;

@Data
public class LotteryNumberDto {

    private Long number;
    private Double limit;
}
