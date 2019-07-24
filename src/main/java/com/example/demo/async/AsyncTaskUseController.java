package com.example.demo.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AsyncTaskUseController
 *
 * @author xiaocuizi
 * @date 2019/7/24 14:45
 * @since 1.0.0
 */
@RestController
public class AsyncTaskUseController {
    @Autowired
    private TreadTasks treadTasks;

    @GetMapping("/startMysync")
    public String useMySyncTask() {
        treadTasks.startMyTreadTask();
        return "hello";
    }
}
