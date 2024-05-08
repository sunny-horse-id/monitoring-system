package com.itheima.controller;

import com.itheima.pojo.Power;
import com.itheima.pojo.Result;
import com.itheima.service.PowerService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/power")
public class PowerController {
    private static final Logger log = LoggerFactory.getLogger(PowerController.class);
    @Autowired
    private PowerService powerService;
    /**
     * 获取每秒发电功率
     * @return
     */
    @GetMapping("/perSecond")
    public Result<Double> perSecond(Double prePower) {
        Double nowPower = powerService.perSecond(prePower);
        return Result.success(nowPower);
    }

    @GetMapping("/minute")
    public Result<Power> getMinute(String date) {
        StringBuilder sb = new StringBuilder(date);
        sb.setCharAt(sb.length() - 1, '0');
        Power power = powerService.getMinute(sb.toString());
        return Result.success(power);
    }

    @GetMapping("/hour")
    public Result<Power> getHour(String date) {
        StringBuilder sb = new StringBuilder(date);
        sb.setCharAt(sb.length() - 1, '0');
        sb.setCharAt(sb.length() - 2, '0');
        Power power = powerService.getHour(sb.toString());
        return Result.success(power);
    }
}