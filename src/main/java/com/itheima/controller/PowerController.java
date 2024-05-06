package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.service.PowerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/power")
public class PowerController {
    @Autowired
    private PowerService powerService;
    /**
     * 获取每秒发电功率
     * @return
     */
    @GetMapping("/perSecond")
    public Result<Double> perSecond(Double prePower) {
        log.info("获取每秒发电功率,先前的功率为：{}", prePower);
        Double nowPower = powerService.perSecond(prePower);
        return Result.success(nowPower);
    }
}
