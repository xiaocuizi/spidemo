package com.example.demo.spi;

/**
 * Charge
 *
 * @author <a href="mailto:cuidaochang@redefine.global">cuidaochang</a>
 * @date 2019/7/23 15:20
 * @since 1.0.0
 */
public interface Charge {
    Boolean process(String args);
    String getType();
}
