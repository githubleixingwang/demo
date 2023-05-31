package com.demo.test.easypoi.controller;

import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.demo.test.easypoi.data.GraphNode;
import com.demo.test.easypoi.data.nodeConstant;
import com.demo.test.easypoi.data.sheet.AddressSheetData;
import com.demo.test.easypoi.service.A;
import com.demo.test.easypoi.util.ExcelStyle;
import com.demo.test.easypoi.data.sheet.CommonSheetData;
import com.demo.test.easypoi.data.sheet.ServiceSheetData;
import com.demo.test.easypoi.util.WriteCsvUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: lxw
 * @date: 2023-05-29  14:27
 */
@RestController
public class TestEportController {

    @Resource
    private A aa;
    @GetMapping("/testCsv")
    public void a(HttpServletResponse response) {
        String a = "[{\"types\": [\"Address\"],\"id\": \"1250\",\"type\": \"Address\",\"props\": {\"byAttackCount\": \"0\",\"firstTime\": \"2022-04-22 10:51:02\",\"showName\": \"192.168.19.27\",\"firstTimeLong\": 1650595862000,\"dataSourceStr\": \"资产\",\"assetName\": \"mysql-test\",\"endTime\": \"2022-06-22 12:51:02\",\"addr\": \"192.168.19.27\",\"endTimeLong\": 1655873462000,\"dataSource\": \"asset\"}\n" +
                "}, {\"types\": [\"Service\"],\"id\": \"1251\",\"type\": \"Service\",\"props\": {\"firstTime\": \"2022-04-22 10:51:02\",\"showName\": \"mysql_3306\",\"firstTimeLong\": 1650595862000,\"dataSourceStr\": \"监控\",\"port\": \"3306\",\"name\": \"mysql\",\"endTime\": \"2022-06-22 12:51:02\",\"dataSource\": \"monitor\",\"endTimeLong\": 1655873462000}\n" +
                "}, {\"types\": [\"Service\"],\"id\": \"1304\",\"type\": \"Service\",\"props\": {\"firstTime\": \"2022-04-22 10:51:02\",\"showName\": \"oracle_1521\",\"firstTimeLong\": 1650595862000,\"dataSourceStr\": \"监控\",\"port\": \"1521\",\"name\": \"oracle\",\"endTime\": \"2022-04-22 13:55:24\",\"dataSource\": \"monitor\",\"endTimeLong\": 1650606924000}\n" +
                "}, {\"types\": [\"Address\"],\"id\": \"1301\",\"type\": \"Address\",\"props\": {\"byAttackCount\": \"0\",\"firstTime\": \"2022-04-22 10:51:02\",\"showName\": \"192.168.53.122\",\"firstTimeLong\": 1650595862000,\"dataSourceStr\": \"资产\",\"assetName\": \"53.122网御星云_pfc106_30\",\"endTime\": \"2022-04-22 10:51:02\",\"addr\": \"192.168.53.122\",\"endTimeLong\": 1650595862000,\"dataSource\": \"asset\"}\n" +
                "}, {\"types\": [\"Address\"],\"id\": \"1302\",\"type\": \"Address\",\"props\": {\"byAttackCount\": \"0\",\"firstTime\": \"2022-04-22 10:51:02\",\"showName\": \"192.168.114.65\",\"firstTimeLong\": 1650595862000,\"dataSourceStr\": \"资产\",\"assetName\": \"65suse_pfc106_30\",\"endTime\": \"2022-04-22 10:52:08\",\"addr\": \"192.168.114.65\",\"endTimeLong\": 1650595928000,\"dataSource\": \"asset\"}\n" +
                "}, {\"types\": [\"Address\"],\"id\": \"1303\",\"type\": \"Address\",\"props\": {\"byAttackCount\": \"0\",\"firstTime\": \"2022-04-22 10:51:02\",\"showName\": \"192.168.114.69\",\"firstTimeLong\": 1650595862000,\"dataSourceStr\": \"资产\",\"assetName\": \"69windows2012r2standard_pfc106_30\",\"endTime\": \"2022-04-22 10:52:10\",\"addr\": \"192.168.114.69\",\"endTimeLong\": 1650595930000,\"dataSource\": \"asset\"}\n" +
                "}]";
        List<GraphNode> nodes = JSONArray.parseArray(a, GraphNode.class);
        Map<String, List<GraphNode>> map = nodes.stream().collect(Collectors.groupingBy(GraphNode::getType));
        List<Map<String, Object>> fileList = Lists.newArrayList();
        for (String key : map.keySet()) {
            Map<String, Object> csvMap = Maps.newHashMap();
            List<GraphNode> graphNodes = map.get(key);
            List<Map<String, Object>> list = graphNodes.stream().map(GraphNode::getProps).collect(Collectors.toList());
            String csvStr = WriteCsvUtil.getCsvData(key, list);
            csvMap.put("fileName", key + ".csv");
            csvMap.put("out", csvStr.getBytes(StandardCharsets.UTF_8));
            fileList.add(csvMap);
        }
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String localDateNowStr = now.format(formatter);
        String fileName = localDateNowStr + "-csv.zip";
        WriteCsvUtil.downloadzipFiles(fileName, fileList, response);
    }

    @GetMapping("/testExcel")
    public void b(HttpServletResponse response) {
        try {
            String a = "[{\"types\": [\"Address\"],\"id\": \"1250\",\"type\": \"Address\",\"props\": {\"byAttackCount\": \"0\",\"firstTime\": \"2022-04-22 10:51:02\",\"showName\": \"192.168.19.27\",\"firstTimeLong\": 1650595862000,\"dataSourceStr\": \"资产\",\"assetName\": \"mysql-test\",\"endTime\": \"2022-06-22 12:51:02\",\"addr\": \"192.168.19.27\",\"endTimeLong\": 1655873462000,\"dataSource\": \"asset\"}\n" +
                    "}, {\"types\": [\"Service\"],\"id\": \"1251\",\"type\": \"Service\",\"props\": {\"firstTime\": \"2022-04-22 10:51:02\",\"showName\": \"mysql_3306\",\"firstTimeLong\": 1650595862000,\"dataSourceStr\": \"监控\",\"port\": \"3306\",\"name\": \"mysql\",\"endTime\": \"2022-06-22 12:51:02\",\"dataSource\": \"monitor\",\"endTimeLong\": 1655873462000}\n" +
                    "}, {\"types\": [\"Service\"],\"id\": \"1304\",\"type\": \"Service\",\"props\": {\"firstTime\": \"2022-04-22 10:51:02\",\"showName\": \"oracle_1521\",\"firstTimeLong\": 1650595862000,\"dataSourceStr\": \"监控\",\"port\": \"1521\",\"name\": \"oracle\",\"endTime\": \"2022-04-22 13:55:24\",\"dataSource\": \"monitor\",\"endTimeLong\": 1650606924000}\n" +
                    "}, {\"types\": [\"Address\"],\"id\": \"1301\",\"type\": \"Address\",\"props\": {\"byAttackCount\": \"0\",\"firstTime\": \"2022-04-22 10:51:02\",\"showName\": \"192.168.53.122\",\"firstTimeLong\": 1650595862000,\"dataSourceStr\": \"资产\",\"assetName\": \"53.122网御星云_pfc106_30\",\"endTime\": \"2022-04-22 10:51:02\",\"addr\": \"192.168.53.122\",\"endTimeLong\": 1650595862000,\"dataSource\": \"asset\"}\n" +
                    "}, {\"types\": [\"Address\"],\"id\": \"1302\",\"type\": \"Address\",\"props\": {\"byAttackCount\": \"0\",\"firstTime\": \"2022-04-22 10:51:02\",\"showName\": \"192.168.114.65\",\"firstTimeLong\": 1650595862000,\"dataSourceStr\": \"资产\",\"assetName\": \"65suse_pfc106_30\",\"endTime\": \"2022-04-22 10:52:08\",\"addr\": \"192.168.114.65\",\"endTimeLong\": 1650595928000,\"dataSource\": \"asset\"}\n" +
                    "}, {\"types\": [\"Address\"],\"id\": \"1303\",\"type\": \"Address\",\"props\": {\"byAttackCount\": \"0\",\"firstTime\": \"2022-04-22 10:51:02\",\"showName\": \"192.168.114.69\",\"firstTimeLong\": 1650595862000,\"dataSourceStr\": \"资产\",\"assetName\": \"69windows2012r2standard_pfc106_30\",\"endTime\": \"2022-04-22 10:52:10\",\"addr\": \"192.168.114.69\",\"endTimeLong\": 1650595930000,\"dataSource\": \"asset\"}\n" +
                    "}]";
            List<GraphNode> nodes = JSONArray.parseArray(a, GraphNode.class);
            Map<String, List<GraphNode>> map = nodes.stream().collect(Collectors.groupingBy(GraphNode::getType));

            // 多个sheet配置参数
            final List<Map<String, Object>> sheetsList = new ArrayList<>();

            for (String key : map.keySet()) {
                List<CommonSheetData> sheetDataList = new ArrayList<>();
                Map<String, Object> exportMap = new HashMap<>();
                final ExportParams exportParams = new ExportParams(null, null, key);
                exportParams.setStyle(ExcelStyle.class);
                // 以下3个参数为API中写死的参数名 分别是sheet配置/导出类（注解定义）/数据集
                exportMap.put("title", exportParams);
                if (nodeConstant.LABEL_ADDRESS.equals(key)) {
                    map.get(key).forEach(graphNode -> {
                        Map<String, Object> props = graphNode.getProps();
                        AddressSheetData sheetData = JSON.parseObject(JSON.toJSONString(props), AddressSheetData.class);
                        sheetDataList.add(sheetData);
                    });
                    exportMap.put("entity", AddressSheetData.class);

                }
                if (nodeConstant.LABEL_SERVICE.equals(key)) {
                    map.get(key).forEach(graphNode -> {
                        Map<String, Object> props = graphNode.getProps();
                        ServiceSheetData sheetData = JSON.parseObject(JSON.toJSONString(props), ServiceSheetData.class);
                        sheetDataList.add(sheetData);
                    });
                    exportMap.put("entity", ServiceSheetData.class);
                }
                exportMap.put("data", sheetDataList);
                // 加入多sheet配置列表
                sheetsList.add(exportMap);
            }

           aa.a(response,sheetsList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
