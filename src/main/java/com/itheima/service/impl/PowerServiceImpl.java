package com.itheima.service.impl;

import com.itheima.pojo.Hydrogen;
import com.itheima.pojo.Power;
import com.itheima.service.PowerService;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    @Override
    public Power getMinute(String date) {
        // 将输入字符串转换为LocalTime对象
        LocalTime time = LocalTime.parse(date, DateTimeFormatter.ofPattern("HH:mm"));
        DecimalFormat df = new DecimalFormat("#.##"); // 创建一个DecimalFormat对象，模式为保留两位小数

        // 初始化结果列表
        List<Double> tmp = new ArrayList<>();
        List<String> rates = new ArrayList<>();
        List<String> dates = new ArrayList<>();

        Power power = new Power();
        // 从输入时间开始，倒推7个10分钟间隔
        for (int i = 0; i < 8; i++) { // 包含输入时间本身，所以是8次循环
            dates.add(time.format(DateTimeFormatter.ofPattern("HH:mm")));
            // 如果是第一次循环，直接生成第一个随机值
            if (i == 0) {
                double randomValue = Math.random() * 10 + 195; // 初始范围调整以符合0.35~0.45的需求
                tmp.add(randomValue);
            } else {
                // 生成满足条件的新随机值
                double lastRate = tmp.get(tmp.size() - 1);
                double newValue = Math.random() * 10 + 195;
                while (Math.abs(newValue - lastRate) > 1) {
                    newValue = Math.random() * 10 + 195;
                }
                tmp.add(newValue);
            }
            // 减去10分钟
            time = time.minusMinutes(10);
        }
        for (int i = 0; i < 8; i++) {
            String formattedValue = df.format(tmp.get(i)); // 格式化该随机值
            // 随机数的范围为195~205，所以范围是10
            rates.add(formattedValue);
        }
        // 使用流API反转列表
        Collections.reverse(dates);
        power.setDate(dates);
        power.setRate(rates);
        return power;
    }

    @Override
    public Power getHour(String date) {
        // 将输入字符串转换为LocalTime对象
        LocalTime time = LocalTime.parse(date, DateTimeFormatter.ofPattern("HH:mm"));
        DecimalFormat df = new DecimalFormat("#.##"); // 创建一个DecimalFormat对象，模式为保留两位小数

        // 初始化结果列表
        List<Double> tmp = new ArrayList<>();
        List<String> rates = new ArrayList<>();
        List<String> dates = new ArrayList<>();

        Power power = new Power();
        // 从输入时间开始，倒推7个10分钟间隔
        for (int i = 0; i < 8; i++) { // 包含输入时间本身，所以是8次循环
            dates.add(time.format(DateTimeFormatter.ofPattern("HH:mm")));
            // 如果是第一次循环，直接生成第一个随机值
            if (i == 0) {
                double randomValue = Math.random() * 10 + 195; // 初始范围调整以符合0.35~0.45的需求
                tmp.add(randomValue);
            } else {
                // 生成满足条件的新随机值
                double lastRate = tmp.get(tmp.size() - 1);
                double newValue = Math.random() * 10 + 195;
                while (Math.abs(newValue - lastRate) > 1) {
                    newValue = Math.random() * 10 + 195;
                }
                tmp.add(newValue);
            }
            // 减去10分钟
            time = time.minusMinutes(60);
        }
        for (int i = 0; i < 8; i++) {
            String formattedValue = df.format(tmp.get(i)); // 格式化该随机值
            // 随机数的范围为195~205，所以范围是10
            rates.add(formattedValue);
        }
        // 使用流API反转列表
        Collections.reverse(dates);
        power.setDate(dates);
        power.setRate(rates);
        return power;
    }
}
