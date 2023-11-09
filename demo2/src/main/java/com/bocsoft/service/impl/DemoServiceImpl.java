package com.bocsoft.service.impl;

import com.bocsoft.entity.FuncEntity;
import com.bocsoft.mapper.FuncMapper;
import com.bocsoft.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private FuncMapper funcMapper;

    @Override
    public FuncEntity getByName(String name) {
        FuncEntity funcEntity = new FuncEntity();
        funcEntity.setName(name);
        return funcMapper.selectByName(funcEntity);
    }
}
