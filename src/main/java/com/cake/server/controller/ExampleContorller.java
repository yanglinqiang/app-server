package com.cake.server.controller;

import com.cake.server.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by ylq on 2018/3/31.
 */
@Controller
public class ExampleContorller extends BaseContorller {
    @Autowired
    ExampleService service;
}
