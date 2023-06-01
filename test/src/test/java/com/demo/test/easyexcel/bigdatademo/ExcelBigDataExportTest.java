package com.demo.test.easyexcel.bigdatademo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ExcelBigDataExportTest {

    @Autowired
    ExcelBigDataExport excelBigDataExport;
    @Test
    public void writeExcelByApi() {
        excelBigDataExport.writeExcelByApi(1048576L);
    }

    @Test
    public void writeExcelByMulSheet() {
        excelBigDataExport.writeExcelByMulSheet(2048575L);
    }

    @Test
    public void writeExcelByMulWrite() {
        excelBigDataExport.writeExcelByMulWrite(1048575L);
    }

    @Test
    public void writeExcelByMulSheetAndWriteChange() {
    excelBigDataExport.writeExcelByMulSheetAndWriteChange(2048575L);
    }
}