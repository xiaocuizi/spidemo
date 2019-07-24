package com.example.demo;

import com.example.demo.spi.Charge;
import com.example.demo.spi.factory.ConsumeFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SpiTest
 *
 * @author <a href="mailto:cuidaochang@redefine.global">cuidaochang</a>
 * @date 2019/7/23 15:35
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpiTest {
    @Autowired
    private ConsumeFactory consumeFactory;



    @Test
    public void testFindConsumeType(){
        String commandName = "assureCharge";
        Charge consumeHandler = consumeFactory.findConsumeType(commandName);
        consumeHandler.process("");
    }
}
