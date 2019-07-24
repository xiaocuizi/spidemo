package com.example.demo.webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * IndexController
 *
 * @author <a href="mailto:cuidaochang@redefine.global">cuidaochang</a>
 * @date 2019/7/23 18:00
 * @since 1.0.0
 */
@RestController
public class IndexController {
    @GetMapping("/index")
    public String index() {
        return "index";
    }

}
