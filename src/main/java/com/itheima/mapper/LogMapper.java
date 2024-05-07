package com.itheima.mapper;

import com.itheima.pojo.Log;
import org.apache.ibatis.annotations.Delete;
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

    /**
     * 根据id删除故障
     * @param id
     */
    @Delete("delete from log where id = #{id}")
    void deleteById(Integer id);
}