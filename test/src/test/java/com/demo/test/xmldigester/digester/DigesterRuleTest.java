package com.demo.test.xmldigester.digester;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.xml.sax.SAXException;

import java.io.IOException;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DigesterRuleTest {

    @Autowired
    private DigesterRule digesterRule;
    @Test
    public void initRule() throws IOException, SAXException {
        digesterRule.initRule();
    }
}