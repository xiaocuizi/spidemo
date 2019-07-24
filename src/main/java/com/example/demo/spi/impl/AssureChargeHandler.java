package com.example.demo.spi.impl;

import com.example.demo.spi.Charge;
import org.springframework.stereotype.Service;

/**
 * AssureChargeHandler
 *
 * @date 2019/7/23 15:22
 * @since 1.0.0
 */
@Service("assureChargeHandler")
public class AssureChargeHandler implements Charge {
    @Override
    public Boolean process(String args) {
        System.out.println("I am assure");
        return true;
    }

    @Override
    public String getType() {
        return "assureCharge";
    }
}
