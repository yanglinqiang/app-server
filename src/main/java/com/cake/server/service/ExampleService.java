package com.cake.server.service;

import com.cake.server.dao.ExampleMapper;
import com.cake.server.entity.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ylq on 2018/3/31.
 */
@Service("exampleService")
public class ExampleService {
    @Autowired
    ExampleMapper exampleMapper;

    public Example get(Integer id) {
        return exampleMapper.selectByPrimaryKey(id);
    }
}
