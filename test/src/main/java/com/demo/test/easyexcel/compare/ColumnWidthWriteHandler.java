package com.demo.test.easyexcel.compare;

import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.handler.context.CellWriteHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.HashSet;
import java.util.Set;

/**
 * 自定义列宽处理器
 * 设置所有列的宽度为指定值
 *
 * @author demo
 */
@Slf4j
public class ColumnWidthWriteHandler implements CellWriteHandler {

    private final int columnWidth;
    private final Set<Integer> processedColumns = new HashSet<>();

    public ColumnWidthWriteHandler(int columnWidth) {
        this.columnWidth = columnWidth;
    }

    @Override
    public void afterCellDispose(CellWriteHandlerContext context) {
        Sheet sheet = context.getWriteSheetHolder().getSheet();
        int columnIndex = context.getColumnIndex();

        // 避免重复设置列宽，每个列只设置一次
        if (!processedColumns.contains(columnIndex)) {
            // 设置列宽（单位：字符数，256为一个字符单位）
            // 例如：40个字符 = 40 * 256
            sheet.setColumnWidth(columnIndex, columnWidth * 256);
            processedColumns.add(columnIndex);
        }
    }
}
