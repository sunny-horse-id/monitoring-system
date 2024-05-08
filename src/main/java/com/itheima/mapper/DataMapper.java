package com.itheima.mapper;

import com.itheima.pojo.Data;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DataMapper {
    /**
     * 从数据库中随机选出144条数据
     * @return
     */
    @Select("select * from data order by rand() limit 144")
    List<Data> getData();
}
