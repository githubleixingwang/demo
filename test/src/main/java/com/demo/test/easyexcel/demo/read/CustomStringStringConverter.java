package com.demo.test.easyexcel.demo.read;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.ReadConverterContext;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.WriteCellData;

/**
 * String and string converter
 *
 * @author Jiaju Zhuang
 */
public class CustomStringStringConverter implements Converter<String> {

    //在java中性别是用 0 1 来标识的  所以是int
    @Override
    public Class<?> supportJavaTypeKey() {
        return String.class;
    }

    // 在excel中是男女汉字 所以是string  easyExcel会将excel单元格的内容解析为easyExcel对应的数据类型
    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    /**
     * 这里读的时候会调用，	将excel的数据类型转为java数据类型
     *
     * @param context
     * @return
     */
    @Override
    public String convertToJavaData(ReadConverterContext<?> context) {
        return "自定义：" + context.getReadCellData().getStringValue();
        /*String stringValue = cellData.getStringValue();
        if (stringValue == null) {
            throw new RuntimeException("性别填写为空");
        }
        if ("男".equals(stringValue)) {
            return 1;
        }
        return 0;*/

    }

    /**
     * 这里是写的时候会调用 不用管
     *
     * @return
     */
    @Override
    public WriteCellData<?> convertToExcelData(WriteConverterContext<String> context) {
        return new WriteCellData<>(context.getValue());
    }

}
