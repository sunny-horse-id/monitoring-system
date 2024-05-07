package com.itheima.mapper;

import com.itheima.pojo.Log;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogMapper {
    /**
     * 根据类型获取故障列表
     * @param type
     * @return
     */
    @Select("select * from log where type = #{type} order by occurrence_time desc")
    List<Log> getLogListByType(Integer type);
}