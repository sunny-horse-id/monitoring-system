package com.itheima.service.impl;

import com.itheima.mapper.LogMapper;
import com.itheima.pojo.Log;
import com.itheima.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;

    /**
     * 根据类型查询日志
     * @param type
     * @return
     */
    @Override
    public List<Log> list(Integer type) {
        return logMapper.getLogListByType(type);
    }

    /**
     * 删除日志
     * @param id
     */
    @Override
    public void delete(Integer id) {
        logMapper.deleteById(id);
    }
}
