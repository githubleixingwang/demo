package com.demo.test.mybatisplus;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.test.po.DemoTest2;
import org.springframework.stereotype.Service;

@Service
public class DemoTest2ServiceImpl extends ServiceImpl<DemoTest2Mapper, DemoTest2> implements DemoTest2Service {
}
