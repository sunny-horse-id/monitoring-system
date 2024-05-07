package com.itheima.controller;

import com.itheima.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hour")
public class HourController {
    private final static Long CUR_HOUR = 476387l;

    /**
     * 获取连续小时数
     * @return
     */
    @GetMapping("")
    public Result<Long> hour() {
        Long currentTimeMillis = System.currentTimeMillis();
        Long hours = currentTimeMillis / (1000 * 60 * 60);
        return Result.success(hours - CUR_HOUR + 2140);
    }
}
