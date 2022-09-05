package com.example.lx0831.service.impl;

import com.example.lx0831.mapper.ClassifyMapper;
import com.example.lx0831.pojo.Classify;
import com.example.lx0831.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassifyServiceImpl implements ClassifyService {
    @Autowired
    private ClassifyMapper cm;

    @Override
    public List<Classify> getClassifies() {
        return cm.selectList(null);
    }
}
