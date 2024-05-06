package com.itheima.service;

public interface PowerService {
    /**
     * 获取每秒的发电功率
     * @return
     */
    Double perSecond(Double prePower);
}
