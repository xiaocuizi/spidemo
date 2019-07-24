package com.example.demo.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * TreadTasks
 *
 * @author xiaocuizi
 * @date 2019/7/24 14:44
 * @since 1.0.0
 */
@Component
public class TreadTasks {

    @Async
    public void startMyTreadTask() {
        System.out.println("this is my async task");
        System.out.println(Thread.currentThread().getName());
    }
}