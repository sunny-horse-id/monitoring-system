package com.itheima.service.impl;

import com.itheima.pojo.Norm;
import com.itheima.service.NormService;
import org.springframework.stereotype.Service;

@Service
public class NormServiceImpl implements NormService {
    // 温度
    private static final Double MAX_TEMPERATURE = 10.5;
    private static final Double MIN_TEMPERATURE = 8.5;
    // 流速
    private static final Double MAX_FLOW_RATE = 6.3;
    private static final Double MIN_FLOW_RATE = 2.3;
    // PH
    private static final Double MAX_PH = 8.7;
    private static final Double MIN_PH = 7.7;
    // 浓度
    private static final Double MAX_DENSITY = 55.0;
    private static final Double MIN_DENSITY = 45.0;

    /**
     * 获取最新一条记录
     * @param preNorm
     * @return
     */
    @Override
    public Norm getNorm(Norm preNorm) {
        Norm norm = new Norm();
        // 修改温度
        Double temperature = preNorm.getTemperature() + (Math.random() * 0.04 - 0.02);
        while (temperature > MAX_TEMPERATURE || temperature < MIN_TEMPERATURE) {
            temperature = preNorm.getTemperature() + (Math.random() * 0.04 - 0.02);
        }
        norm.setTemperature(temperature);
        // 修改流速
        Double flowRate = preNorm.getFlowRate() + (Math.random() * 0.04 - 0.02);
        while (flowRate > MAX_FLOW_RATE || flowRate < MIN_FLOW_RATE) {
            flowRate = preNorm.getFlowRate() + (Math.random() * 0.04 - 0.02);
        }
        norm.setFlowRate(flowRate);
        // 修改PH
        Double pH = preNorm.getPh() + (Math.random() * 0.04 - 0.02);
        while (pH > MAX_PH || pH < MIN_PH) {
            pH = preNorm.getPh() + (Math.random() * 0.04 - 0.02);
        }
        norm.setPh(pH);
        // 修改浓度
        Double density = preNorm.getDensity() + (Math.random() * 0.04 - 0.02);
        while (density > MAX_DENSITY || density < MIN_DENSITY) {
            density = preNorm.getDensity() + (Math.random() * 0.04 - 0.02);
        }
        norm.setDensity(density);
        return norm;
    }
}