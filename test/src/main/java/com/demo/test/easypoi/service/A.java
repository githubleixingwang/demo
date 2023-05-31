package com.demo.test.easypoi.service;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

/**
 * @author: lxw
 * @date: 2023-05-29  16:05
 */
@Service
public class A {

    public void a(HttpServletResponse response, List<Map<String, Object>> sheetsList) throws Exception{
        // 导出文件
        // 核心方法：导出含多个sheet的excel文件 【注意，该方法第二个参数必须使用ExcelType.HSSF，使用ExcelType.XSSF会报错!!!】
        final Workbook workbook = ExcelExportUtil.exportExcel(sheetsList, ExcelType.HSSF);

        String fileName = new String("文件名.xls".getBytes("GBK"), StandardCharsets.ISO_8859_1);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        OutputStream outputStream = response.getOutputStream();
        response.flushBuffer();
        workbook.write(outputStream);
        // 写完数据关闭流
        outputStream.close();
    }
}
