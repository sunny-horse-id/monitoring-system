package com.itheima.controller;

import com.itheima.pojo.Hydrogen;
import com.itheima.pojo.Result;
import com.itheima.service.HydrogenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/hydrogen")
@Slf4j
public class HydrogenController {
    @Autowired
    private HydrogenService hydrogenService;
    @GetMapping
    public Result<Hydrogen> getHydrogen(String date) {
        StringBuilder sb = new StringBuilder(date);
        sb.setCharAt(sb.length() - 1, '0');
        Hydrogen hydrogen = hydrogenService.getHydrogen(sb.toString());
        return Result.success(hydrogen);
    }
}