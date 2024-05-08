package com.itheima.service.impl;

import com.itheima.pojo.Hydrogen;
import com.itheima.service.HydrogenService;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class HydrogenServiceImpl implements HydrogenService {
    @Override
    public Hydrogen getHydrogen(String date) {
        // 将输入字符串转换为LocalTime对象
        LocalTime time = LocalTime.parse(date, DateTimeFormatter.ofPattern("HH:mm"));

        // 初始化结果列表
        List<String> rates = new ArrayList<>();
        List<String> dates = new ArrayList<>();

        Hydrogen hydrogen = new Hydrogen();
        // 从输入时间开始，倒推7个10分钟间隔
        for (int i = 0; i < 8; i++) { // 包含输入时间本身，所以是8次循环
            dates.add(time.format(DateTimeFormatter.ofPattern("HH:mm")));
            DecimalFormat df = new DecimalFormat("#.##"); // 创建一个DecimalFormat对象，模式为保留两位小数
            double randomValue = Math.random() * 0.1 + 0.35; // 计算随机值
            String formattedValue = df.format(randomValue); // 格式化该随机值
            // 随机数的范围为0.35~0.45
            rates.add(formattedValue);
            // 减去10分钟
            time = time.minusMinutes(10);
        }
        // 使用流API反转列表
        Collections.reverse(dates);
        hydrogen.setDate(dates);
        hydrogen.setRate(rates);
        return hydrogen;
    }
}
