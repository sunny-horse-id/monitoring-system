package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Data {
    private Integer id; //主键id
    private Double voltage;
    private Double electricCurrent;
    private Double pressure;
    private Double concentration;
}
