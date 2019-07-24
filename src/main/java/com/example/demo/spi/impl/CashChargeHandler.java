package com.example.demo.spi.impl;

import com.example.demo.spi.Charge;
import org.springframework.stereotype.Service;

/**
 * CashChargeHandler
 *
 * @date 2019/7/23 15:21
 * @since 1.0.0
 */
@Service("cashChargeHandler")
public class CashChargeHandler implements Charge {
    @Override
    public Boolean process(String args) {
        System.out.println("I am Cash");
        return true;
    }

    @Override
    public String getType() {
        return "cashCharge";
    }
}
