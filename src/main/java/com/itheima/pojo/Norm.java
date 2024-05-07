package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Norm {
    private Double temperature;
    private Double flowRate;
    private Double density;
    private Double ph;
}
