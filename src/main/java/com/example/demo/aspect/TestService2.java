package com.example.demo.aspect;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * TestService2
 *
 * @author <a href="mailto:cuidaochang@redefine.global">cuidaochang</a>
 * @date 2019/7/23 14:03
 * @since 1.0.0
 */
@Service
public class TestService2 {

    @Async
    public void executeAsyncTask(int i){
        System.out.println("执行异步任务:"+i);
    }

    @Async
    public void executeAsyncTask2(int i){
        System.out.println("执行异步任务2:"+i);
    }
}
