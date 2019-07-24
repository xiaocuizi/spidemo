package com.example.demo;

import com.example.demo.aspect.TestService2;
import com.example.demo.config.AopConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * TestController
 *
 * @author <a href="mailto:cuidaochang@redefine.global">cuidaochang</a>
 * @date 2019/7/23 14:14
 * @since 1.0.0
 */
public class TestController {
    public static void main(String[] args) {
        int i1 = Runtime.getRuntime().availableProcessors();
        System.out.println("processors:"+i1);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);

        TestService2 testService2 = context.getBean(TestService2.class);
        for (int i = 0; i < 10; i++) {
            testService2.executeAsyncTask(i);
            testService2.executeAsyncTask2(i);
        }
        context.close();

    }
}
