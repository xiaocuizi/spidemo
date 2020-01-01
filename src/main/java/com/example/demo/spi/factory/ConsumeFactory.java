package com.example.demo.spi.factory;

import com.example.demo.spi.Charge;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConsumeFactory
 *
 * @date 2019/7/23 15:26
 * @since 1.0.0
 */
@Service
public class ConsumeFactory implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    private static Map<String, Charge> consumeMap = new ConcurrentHashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void init() {
        ServiceLoader<Charge> operations = ServiceLoader.load(Charge.class);
        Iterator<Charge> operationIterator = operations.iterator();
        while (operationIterator.hasNext()) {
            Charge consume = operationIterator.next();
            consumeMap.put(consume.getType(), applicationContext.getBean(consume.getClass()));
        }
    }

    /**
     * @param consumeType
     * @return
     */
    public Charge findConsumeType(String consumeType) {
        if (consumeMap.containsKey(consumeType)) {
            return consumeMap.get(consumeType);
        }
        return null;
    }

}
