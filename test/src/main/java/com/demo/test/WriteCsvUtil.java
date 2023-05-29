package com.demo.test;

import com.alibaba.fastjson.JSON;
import com.demo.test.nodeData.*;
import com.google.common.primitives.Bytes;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author: lxw
 * @date: 2023-05-29  14:06
 */
public class WriteCsvUtil {
    /**
     * CSV文件列分隔符
     */
    private static final String CSV_COLUMN_SEPARATOR = ",";
    /**
     * CSV文件行分隔符
     */
    private static final String CSV_ROW_SEPARATOR = System.lineSeparator();

    public static String getCsvData(String type, List<Map<String, Object>> list) {

        StringBuffer buf = new StringBuffer();
        // 组装表头
        String header = CsvEnum.getHeader(type);
        if (StringUtils.isNotBlank(header)) {
            for (String title : header.split(",")) {
                buf.append(title).append(CSV_COLUMN_SEPARATOR);
            }
            buf.append(CSV_ROW_SEPARATOR);
            //组装行数据
            if (type.equals(CsvEnum.ADDRESS.getType())) {
                list.forEach(map -> {
                    AddressNode node = JSON.parseObject(JSON.toJSONString(map), AddressNode.class);
                    buf.append(Optional.ofNullable(node.getAssetName()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append(Optional.ofNullable(node.getAddr()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append(Optional.ofNullable(node.getByAttackCount()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append(Optional.ofNullable(node.getDataSourceStr()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append("\t" + Optional.ofNullable(node.getFirstTime()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append("\t" + Optional.ofNullable(node.getEndTime()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append(CSV_ROW_SEPARATOR);
                });
            }
            if (type.equals(CsvEnum.SERVICE.getType())) {
                list.forEach(map -> {
                    ServiceNode node = JSON.parseObject(JSON.toJSONString(map), ServiceNode.class);
                    buf.append(Optional.ofNullable(node.getName()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append(Optional.ofNullable(node.getPort()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append(Optional.ofNullable(node.getDataSourceStr()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append("\t" + Optional.ofNullable(node.getFirstTime()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append("\t" + Optional.ofNullable(node.getEndTime()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append(CSV_ROW_SEPARATOR);
                });
            }
            if (type.equals(CsvEnum.WEAKNESS.getType())) {
                list.forEach(map -> {
                    WeaknessNode node = JSON.parseObject(JSON.toJSONString(map), WeaknessNode.class);
                    buf.append(Optional.ofNullable(node.getName()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append(Optional.ofNullable(node.getWeaknessTypeStr()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append("\t" + Optional.ofNullable(node.getFirstTime()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append("\t" + Optional.ofNullable(node.getEndTime()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append(CSV_ROW_SEPARATOR);
                });
            }
            if (type.equals(CsvEnum.ATTACKER.getType())) {
                list.forEach(map -> {
                    AttackerNode node = JSON.parseObject(JSON.toJSONString(map), AttackerNode.class);
                    buf.append(Optional.ofNullable(node.getAddr()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append("\t" + Optional.ofNullable(node.getFirstTime()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append("\t" + Optional.ofNullable(node.getEndTime()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append(CSV_ROW_SEPARATOR);
                });
            }
            if (type.equals(CsvEnum.ALERTNAMETYPE.getType())) {
                list.forEach(map -> {
                    AlertNameTypeNode node = JSON.parseObject(JSON.toJSONString(map), AlertNameTypeNode.class);
                    buf.append(Optional.ofNullable(node.getName()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append("\t" + Optional.ofNullable(node.getFirstTime()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append("\t" + Optional.ofNullable(node.getEndTime()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append(CSV_ROW_SEPARATOR);
                });
            }
            if (type.equals(CsvEnum.FILEHASH.getType())) {
                list.forEach(map -> {
                    FileHashNode node = JSON.parseObject(JSON.toJSONString(map), FileHashNode.class);
                    buf.append(Optional.ofNullable(node.getHashValue()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append(Optional.ofNullable(node.getDataType()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append(Optional.ofNullable(node.getDataSourceStr()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append("\t" + Optional.ofNullable(node.getFirstTime()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append("\t" + Optional.ofNullable(node.getEndTime()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append(CSV_ROW_SEPARATOR);
                });
            }
            if (type.equals(CsvEnum.LOGTYPE.getType())) {
                list.forEach(map -> {
                    LogTypeNode node = JSON.parseObject(JSON.toJSONString(map), LogTypeNode.class);
                    buf.append(Optional.ofNullable(node.getName()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append("\t" + Optional.ofNullable(node.getFirstTime()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append("\t" + Optional.ofNullable(node.getEndTime()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append(CSV_ROW_SEPARATOR);
                });
            }
            if (type.equals(CsvEnum.INTELLIGENCETYPE.getType())) {
                list.forEach(map -> {
                    IntelligenceTypeNode node = JSON.parseObject(JSON.toJSONString(map), IntelligenceTypeNode.class);
                    buf.append(Optional.ofNullable(node.getName()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append("\t" + Optional.ofNullable(node.getFirstTime()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append("\t" + Optional.ofNullable(node.getEndTime()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append(CSV_ROW_SEPARATOR);
                });
            }
            if (type.equals(CsvEnum.SAMPLEFILE.getType())) {
                list.forEach(map -> {
                    SampleFileNode node = JSON.parseObject(JSON.toJSONString(map), SampleFileNode.class);
                    buf.append(Optional.ofNullable(node.getName()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append(Optional.ofNullable(node.getLinkRegion()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append(Optional.ofNullable(node.getFileNature()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append("\t" + Optional.ofNullable(node.getFirstTime()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append("\t" + Optional.ofNullable(node.getEndTime()).orElse("")).append(CSV_COLUMN_SEPARATOR);
                    buf.append(CSV_ROW_SEPARATOR);
                });
            }
        }
        return buf.toString();
    }


    /**
     * 下载压缩包
     *
     * @param fileName 压缩包名称
     * @param fileList 压缩包中文件集合
     * @param response
     */
    public static void downloadzipFiles(String fileName, List<Map<String, Object>> fileList, HttpServletResponse response) {
        byte commonCsvHead[] = {(byte) 0xEF, (byte) 0xBB, (byte) 0xBF};
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(response.getOutputStream()); OutputStream out = null) {
            //下载压缩包
            response.setContentType("application/zip");
            response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));
            // 创建 ZipEntry 对象
            for (Map map : fileList) {
                ZipEntry zipEntry = new ZipEntry((String) map.get("fileName"));
                zipOutputStream.putNextEntry(zipEntry);
                zipOutputStream.write(Bytes.concat(commonCsvHead, (byte[]) map.get("out")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

