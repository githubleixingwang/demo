package com.demo.test.easyexcel.compare;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.read.listener.ReadListener;
import com.demo.test.easyexcel.util.TestFileUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.*;

/**
 * 数据对比工具类
 * 读取指定的Excel文件，对比两列数据，将相同和不同的数据分别输出到新的列中
 *
 * @author demo
 */
@Slf4j
public class DataCompareUtil {

    /**
     * 字符串比较器：按字母顺序排序，null和空字符串排在最后
     */
    private static final Comparator<String> STRING_COMPARATOR = (s1, s2) -> {
        if (s1 == null && s2 == null)
            return 0;
        if (s1 == null)
            return 1; // null排在最后
        if (s2 == null)
            return -1;
        if (s1.isEmpty() && s2.isEmpty())
            return 0;
        if (s1.isEmpty())
            return 1; // 空字符串排在非空字符串之后
        if (s2.isEmpty())
            return -1;
        return s1.compareToIgnoreCase(s2); // 忽略大小写排序
    };

    /**
     * 处理Excel文件，对比两列数据
     *
     * @param inputFilePath  输入文件路径
     * @param outputFilePath 输出文件路径
     */
    public static void compareData(String inputFilePath, String outputFilePath) {
        // 1. 读取表头
        final String[] headers = new String[2];
        EasyExcel.read(inputFilePath, CompareData.class, new ReadListener<CompareData>() {
            @Override
            public void invokeHead(Map<Integer, ReadCellData<?>> headMap, AnalysisContext context) {
                // 读取表头
                ReadCellData<?> cell0 = headMap.get(0);
                ReadCellData<?> cell1 = headMap.get(1);
                headers[0] = (cell0 != null && cell0.getStringValue() != null) ? cell0.getStringValue() : "列1";
                headers[1] = (cell1 != null && cell1.getStringValue() != null) ? cell1.getStringValue() : "列2";
            }

            @Override
            public void invoke(CompareData data, AnalysisContext context) {
                // 不需要处理数据
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                // 读取完成
            }
        }).sheet().headRowNumber(1).doRead();

        String header1 = headers[0];
        String header2 = headers[1];

        // 2. 读取所有数据行（不包括表头）- 使用Map方式直接读取，确保空值也能读取
        final List<String> column1List = new ArrayList<>();
        final List<String> column2List = new ArrayList<>();

        EasyExcel.read(inputFilePath, new ReadListener<Map<Integer, String>>() {
            @Override
            public void invokeHead(Map<Integer, ReadCellData<?>> headMap, AnalysisContext context) {
                // 表头已在上面读取，这里不需要处理
            }

            @Override
            public void invoke(Map<Integer, String> rowData, AnalysisContext context) {
                // 使用Map方式直接读取原始数据，确保空值也能读取
                // 索引0是第一列，索引1是第二列
                String col1 = rowData.get(0);
                String col2 = rowData.get(1);

                // 完全保留原始数据，不做任何处理（不去重、不trim、保持原样）
                // 如果Map中没有对应的key（单元格为空），get会返回null，这是正常的
                column1List.add(col1);
                column2List.add(col2);

                // 调试日志：打印前几条数据
                if (column1List.size() <= 5) {
                    log.debug("读取第{}行 - 列1: [{}], 列2: [{}]", column1List.size(),
                            col1 != null ? col1 : "null",
                            col2 != null ? col2 : "null");
                }
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                log.info("数据读取完成，共读取{}条数据", column1List.size());
            }
        }).sheet()
                .headRowNumber(1) // 跳过第一行表头
                .doRead();

        if (column1List.isEmpty() && column2List.isEmpty()) {
            log.warn("Excel文件没有数据");
            return;
        }

        log.info("读取到{}条数据，列1数据: {}条，列2数据: {}条",
                Math.max(column1List.size(), column2List.size()),
                column1List.size(),
                column2List.size());

        // 3. 提取去重后的数据用于对比（用于计算相同和差异数据）
        // 注意：这里需要对数据进行trim和去空处理，以便正确对比
        Set<String> column1Set = new LinkedHashSet<>();
        Set<String> column2Set = new LinkedHashSet<>();

        for (String val : column1List) {
            if (val != null && !val.trim().isEmpty()) {
                column1Set.add(val.trim());
            }
        }
        for (String val : column2List) {
            if (val != null && !val.trim().isEmpty()) {
                column2Set.add(val.trim());
            }
        }

        log.info("列1去重后数据: {}条, 列2去重后数据: {}条", column1Set.size(), column2Set.size());

        // 4. 找出相同数据和差异数据
        // 相同数据（两列都有的数据）
        Set<String> sameDataSet = new LinkedHashSet<>(column1Set);
        sameDataSet.retainAll(column2Set);
        List<String> sameDataList = new ArrayList<>(sameDataSet);
        // 按字母顺序排序
        Collections.sort(sameDataList, STRING_COMPARATOR);

        // 差异数据1（第一列有，第二列没有的）
        Set<String> diffData1Set = new LinkedHashSet<>(column1Set);
        diffData1Set.removeAll(column2Set);
        List<String> diffData1List = new ArrayList<>(diffData1Set);
        // 按字母顺序排序
        Collections.sort(diffData1List, STRING_COMPARATOR);

        // 差异数据2（第二列有，第一列没有的）
        Set<String> diffData2Set = new LinkedHashSet<>(column2Set);
        diffData2Set.removeAll(column1Set);
        List<String> diffData2List = new ArrayList<>(diffData2Set);
        // 按字母顺序排序
        Collections.sort(diffData2List, STRING_COMPARATOR);

        log.info("相同数据: {}条", sameDataList.size());
        log.info("差异数据1: {}条", diffData1List.size());
        log.info("差异数据2: {}条", diffData2List.size());

        // 5. 对列1和列2的数据进行排序（按字母顺序）
        List<String> sortedColumn1List = new ArrayList<>(column1List);
        Collections.sort(sortedColumn1List, STRING_COMPARATOR);

        List<String> sortedColumn2List = new ArrayList<>(column2List);
        Collections.sort(sortedColumn2List, STRING_COMPARATOR);

        // 6. 构建结果数据
        List<CompareResultData> resultList = new ArrayList<>();

        // 计算最大行数（包括原始数据、相同数据、差异数据1、差异数据2）
        // 原始数据行数
        int originalDataRows = Math.max(sortedColumn1List.size(), sortedColumn2List.size());
        // 结果数据行数（相同数据、差异数据1、差异数据2）
        int resultDataRows = Math.max(Math.max(sameDataList.size(), diffData1List.size()), diffData2List.size());
        int maxRows = Math.max(originalDataRows, resultDataRows);

        // 添加数据行（从第二行开始，第一行是表头，由EasyExcel自动生成）
        for (int i = 0; i < maxRows; i++) {
            CompareResultData result = new CompareResultData();

            // 原始第一列数据（已排序）
            if (i < sortedColumn1List.size()) {
                result.setColumn1(sortedColumn1List.get(i));
            }

            // 原始第二列数据（已排序）
            if (i < sortedColumn2List.size()) {
                result.setColumn2(sortedColumn2List.get(i));
            }

            // 相同数据（从第二行开始，第一行是表头）
            if (i < sameDataList.size()) {
                result.setSameData(sameDataList.get(i));
            }

            // 差异数据1（从第二行开始，第一行是表头）
            if (i < diffData1List.size()) {
                result.setDiffData1(diffData1List.get(i));
            }

            // 差异数据2（从第二行开始，第一行是表头）
            if (i < diffData2List.size()) {
                result.setDiffData2(diffData2List.get(i));
            }

            resultList.add(result);
        }

        // 7. 添加统计行
        CompareResultData statRow = new CompareResultData();
        statRow.setColumn1("共计" + sortedColumn1List.size());
        statRow.setColumn2("共计" + sortedColumn2List.size());
        statRow.setSameData("共计" + sameDataList.size());
        statRow.setDiffData1("共计" + diffData1List.size());
        statRow.setDiffData2("共计" + diffData2List.size());
        resultList.add(statRow);

        // 8. 构建动态表头
        List<List<String>> headList = new ArrayList<>();
        List<String> head1 = new ArrayList<>();
        head1.add(header1);
        headList.add(head1);

        List<String> head2 = new ArrayList<>();
        head2.add(header2);
        headList.add(head2);

        List<String> head3 = new ArrayList<>();
        head3.add("相同数据");
        headList.add(head3);

        List<String> head4 = new ArrayList<>();
        head4.add("差异数据1");
        headList.add(head4);

        List<String> head5 = new ArrayList<>();
        head5.add("差异数据2");
        headList.add(head5);

        // 9. 构建写入数据（使用List<List<Object>>格式）
        List<List<Object>> dataListForWrite = new ArrayList<>();
        for (int i = 0; i < resultList.size(); i++) {
            CompareResultData result = resultList.get(i);
            List<Object> row = new ArrayList<>();
            // 确保所有值都写入，null值转换为空字符串
            row.add(result.getColumn1() != null ? result.getColumn1() : "");
            row.add(result.getColumn2() != null ? result.getColumn2() : "");
            row.add(result.getSameData() != null ? result.getSameData() : "");
            row.add(result.getDiffData1() != null ? result.getDiffData1() : "");
            row.add(result.getDiffData2() != null ? result.getDiffData2() : "");
            dataListForWrite.add(row);

            // 调试日志：打印前几条数据
            if (i < 5) {
                log.debug("写入第{}行 - 列1: [{}], 列2: [{}]", i + 1,
                        result.getColumn1() != null ? result.getColumn1() : "null",
                        result.getColumn2() != null ? result.getColumn2() : "null");
            }
        }

        log.info("准备写入{}行数据", dataListForWrite.size());

        // 10. 写入结果到Excel文件
        File outputFile = new File(outputFilePath);
        if (outputFile.getParentFile() != null && !outputFile.getParentFile().exists()) {
            outputFile.getParentFile().mkdirs();
        }

        EasyExcel.write(outputFilePath)
                .head(headList)
                .registerWriteHandler(new ColumnWidthWriteHandler(40)) // 设置所有列宽为40
                .sheet("对比结果")
                .doWrite(dataListForWrite);

        log.info("对比完成，结果已保存到: {}", outputFilePath);
    }

    /**
     * 主方法，用于测试
     */
    public static void main(String[] args) {
        // 示例用法
        String inputPath = TestFileUtil.getPath() + File.separator + "easyexcel" + File.separator
                + "compare" + File.separator + "input.xlsx";
        String outputPath = TestFileUtil.getPath() + File.separator + "easyexcel" + File.separator
                + "compare" + File.separator + "output.xlsx";

        compareData(inputPath, outputPath);
    }
}
