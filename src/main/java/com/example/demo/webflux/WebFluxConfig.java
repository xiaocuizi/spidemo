package com.example.demo.webflux;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.DispatcherHandler;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.server.WebHandler;

/**
 * WebFluxConfig
 *
 * @author <a href="mailto:cuidaochang@redefine.global">cuidaochang</a>
 * @date 2019/7/23 17:58
 * @since 1.0.0
 */
@Configuration
@ComponentScan
@EnableWebFlux
public class WebFluxConfig implements WebFluxConfigurer {
    /**
     *
     * @param applicationContext
     * @return
     */
    @Bean
    public WebHandler webHandler(ApplicationContext applicationContext) {
        DispatcherHandler dispatcherHandler = new DispatcherHandler(applicationContext);
        return dispatcherHandler;
    }
}
