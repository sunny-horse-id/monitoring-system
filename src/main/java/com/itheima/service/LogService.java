package com.itheima.service;

import com.itheima.pojo.Log;

import java.util.List;

public interface LogService {
    /**
     * 获取故障列表
     * @param type
     * @return
     */
    List<Log> list(Integer type);
}
