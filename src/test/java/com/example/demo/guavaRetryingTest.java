package com.example.demo;

import com.github.rholder.retry.*;
import com.google.common.base.Predicates;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * guavaRetryingTest
 *
 * @author <a href="mailto:cuidaochang@redefine.global">cuidaochang</a>
 * @date 2019/7/23 16:00
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class guavaRetryingTest {

    /**
     * 参考{ @link https://www.toutiao.com/a6712403747315646987/?tt_from=weixin&utm_campaign=client_share&wxshare_count=1&timestamp=1563028216&app=news_article&utm_source=weixin&utm_medium=toutiao_ios&req_id=20190713223015010152019225820EE1F&group_id=6712403747315646987}
     *
     * @return
     * @throws Exception
     */
    @Test
    public void testTry() throws Exception {
        //定义重试机制
        Retryer<Boolean> retryer = RetryerBuilder.<Boolean>newBuilder()
                //retryIf 重试条件
                .retryIfException()
                .retryIfRuntimeException()
                .retryIfExceptionOfType(Exception.class)
                .retryIfException(Predicates.equalTo(new Exception()))
                .retryIfResult(Predicates.equalTo(false))
                //等待策略：每次请求间隔1s
                .withWaitStrategy(WaitStrategies.fixedWait(1, TimeUnit.SECONDS))
                //停止策略 : 尝试请求6次
                .withStopStrategy(StopStrategies.stopAfterAttempt(6))
                //时间限制 : 某次请求不得超过2s , 类似: TimeLimiter timeLimiter = new SimpleTimeLimiter();
                .withAttemptTimeLimiter(AttemptTimeLimiters.fixedTimeLimit(2, TimeUnit.SECONDS))
                .build();
        //定义请求实现
        Callable<Boolean> callable = new Callable<Boolean>() {
            int times = 1;

            @Override
            public Boolean call() throws Exception {
                // log.info("call times={}", times);
                System.out.println("call times={}" + times);
                times++;
                if (times == 2) {
                    throw new NullPointerException();
                } else if (times == 3) {
                    throw new Exception();
                } else if (times == 4) {
                    throw new RuntimeException();
                } else if (times == 5) {
                    return false;
                } else {
                    return true;
                }
            }
        };
        //利用重试器调用请求
        //return retryer.call(callable);
        return;
    }
}
