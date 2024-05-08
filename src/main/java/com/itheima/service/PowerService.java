package com.itheima.service;

import com.itheima.pojo.Power;

public interface PowerService {
    /**
     * 获取每秒的发电功率
     * @return
     */
    Double perSecond(Double prePower);

    Power getMinute(String date);

    Power getHour(String string);
}
