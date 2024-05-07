package com.itheima.service.impl;

import com.itheima.service.PowerService;
import org.springframework.stereotype.Service;

@Service
public class PowerServiceImpl implements PowerService {
    // 每秒发电功能的最大值
    private final static Double MAX_POWER = 202.0;
    // 每秒发电功率的最小值
    private final static Double MIN_POWER = 198.0;
    /**
     * 每秒的发电功率
     * @return
     */
    @Override
    public Double perSecond(Double prePower) {
        // 生成大小从-0.1~0.1的随机数
        Double random = prePower + Math.random() * 0.04 - 0.02;
        while (random > MAX_POWER || random < MIN_POWER) {
            random = prePower + Math.random() * 0.04 - 0.02;
        }
        return random;
    }
}
