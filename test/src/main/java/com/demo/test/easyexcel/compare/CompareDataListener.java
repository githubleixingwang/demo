package com.demo.test.easyexcel.compare;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 读取对比数据的监听器
 *
 * @author demo
 */
@Slf4j
public class CompareDataListener implements ReadListener<CompareData> {

    /**
     * 存储读取到的数据
     */
    private List<CompareData> dataList = ListUtils.newArrayList();

    @Override
    public void invoke(CompareData data, AnalysisContext context) {
        // 跳过表头行（第一行），只处理数据行
        if (context.readRowHolder().getRowIndex() > 0) {
            dataList.add(data);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("数据读取完成，共读取{}条数据", dataList.size());
    }

    /**
     * 获取读取到的数据列表
     */
    public List<CompareData> getDataList() {
        return dataList;
    }
}
