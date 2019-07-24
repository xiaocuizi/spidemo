package com.example.demo.spi;

/**
 * Charge
 *
 * @date 2019/7/23 15:20
 * @since 1.0.0
 */
public interface Charge {
    Boolean process(String args);
    String getType();
}
