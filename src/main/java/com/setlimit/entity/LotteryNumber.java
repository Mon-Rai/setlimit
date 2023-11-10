package com.setlimit.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class LotteryNumber {

    @Id
    private Long number;
    @Column(name = "booking_amount_limit")
    private Double limit;

}
