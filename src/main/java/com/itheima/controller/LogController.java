package com.itheima.controller;

import com.itheima.pojo.Log;
import com.itheima.pojo.Result;
import com.itheima.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/log")
@Slf4j
public class LogController {
    @Autowired
    private LogService logService;

    /**
     * 请求获取故障类型列表
     * @param type
     * @return
     */
    @GetMapping("")
    public Result<List<Log>> list(Integer type) {
        log.info("请求获取的故障类型为：{}", type);
        List<Log> logs = logService.list(type);
        return Result.success(logs);
    }
}
