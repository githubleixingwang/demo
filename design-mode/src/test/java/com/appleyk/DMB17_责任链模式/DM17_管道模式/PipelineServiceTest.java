package com.appleyk.DMB17_责任链模式.DM17_管道模式;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PipelineServiceTest {

    @Resource
    private PipelineService pipelineService;
    @Test
    public void pipelineTest() {
        pipelineService.pipelineTest();
    }
}