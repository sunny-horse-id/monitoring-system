package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/data")
public class DataController {
    @Autowired
    private DataService dataService;

    @GetMapping
    public Result<List<Map<String, Object>>> getData() {
        List<Map<String, Object>> res = dataService.getData();
        return Result.success(res);
    }
}