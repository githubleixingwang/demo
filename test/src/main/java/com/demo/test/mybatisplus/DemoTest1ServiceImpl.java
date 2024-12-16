package com.demo.test.mybatisplus;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.test.po.DemoTest1;
import org.springframework.stereotype.Service;

@Service
public class DemoTest1ServiceImpl extends ServiceImpl<DemoTest1Mapper, DemoTest1> implements DemoTest1Service {
}
