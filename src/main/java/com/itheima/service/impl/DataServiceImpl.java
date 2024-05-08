package com.itheima.service.impl;

import com.itheima.mapper.DataMapper;
import com.itheima.pojo.Data;
import com.itheima.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;

@Service
public class DataServiceImpl implements DataService {
    @Autowired
    private DataMapper dataMapper;
    @Override
    public List<Map<String, Object>> getData() {
        List<Map<String, Object>> res = new ArrayList<>();
        List<Data> data = dataMapper.getData();
        Map<String, Object> voltageMap = new LinkedHashMap<>();
        voltageMap.put("name", "发电侧电压/V");
        Map<String, Object> electricCurrentMap = new LinkedHashMap<>();
        electricCurrentMap.put("name", "发电侧电流/A");
        Map<String, Object> pressureMap = new LinkedHashMap<>();
        pressureMap.put("name", "氢气罐压力");
        Map<String, Object> concentrationMap = new LinkedHashMap<>();
        concentrationMap.put("name", "流体浓度梯度");
        Map<String, Object> healthMap = new LinkedHashMap<>();
        healthMap.put("name", "储能侧健康度/%");
        DecimalFormat df = new DecimalFormat("#.00");
        double randomDecimal = Math.random() * 99 + 1;
        for (int i = 0; i < data.size(); i++) {
            Data d = data.get(i);
            // 创建一个新的哈希表来存储当前数据点的所有属性
            voltageMap.put("date_" + i, d.getVoltage());
            electricCurrentMap.put("date_" + i, d.getElectricCurrent());
            pressureMap.put("date_" + i, d.getPressure());
            concentrationMap.put("date_" + i, d.getConcentration());
            randomDecimal = randomDecimal - Math.random() * 0.1;
            randomDecimal = Double.parseDouble(df.format(Math.max(randomDecimal, 0)));
            healthMap.put("date_" + i, randomDecimal);
        }
        res.add(voltageMap);
        res.add(electricCurrentMap);
        res.add(pressureMap);
        res.add(concentrationMap);
        res.add(healthMap);
        return res;
    }
}
