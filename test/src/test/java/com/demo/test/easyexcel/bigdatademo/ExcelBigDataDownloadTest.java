package com.demo.test.easyexcel.bigdatademo;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ExcelBigDataDownloadTest {

    @Autowired
    private ExcelBigDataDownload excelBigDataDownload;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void downloadExcelByApi() {
        MockHttpServletResponse response = new MockHttpServletResponse();
        try {
            excelBigDataDownload.downloadExcelByApi(1000L,response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void writeExcelByMulSheet() {
    }

    @Test
    public void writeExcelByMulWrite() {
    }

    @Test
    public void writeExcelByMulSheetAndWriteChange() {
    }
}