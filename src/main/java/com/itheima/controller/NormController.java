package com.itheima.controller;

import com.itheima.pojo.Norm;
import com.itheima.pojo.Result;
import com.itheima.service.NormService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/norm")
@Slf4j
public class NormController {
    @Autowired
    private NormService normService;

    /**
     * 获取指标
     * @return
     */
    @PostMapping("")
    public Result<Norm> getNorm(@RequestBody Norm preNorm) {
        Norm nowNorm = normService.getNorm(preNorm);
        return Result.success(nowNorm);
    }
}
