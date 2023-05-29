package com.appleyk.DMB19_备忘录模式.DM19.事务回滚;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>事务日志类</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date Created on 下午 1:05 2018-11-21
 */
public class TransactionJournal {

    /**
     * 日志序号
     */
    private Integer logNum;

    /**
     * 假设数据是存进数据库的
     */
    private List<Integer> data = new ArrayList<>();

    public TransactionJournal(Integer logNum, List<Integer> data) {
        this.logNum = logNum;
        if (data != null && data.size() > 0) {
            this.data.addAll(data);
        }
    }

    public Integer getLogNum() {
        return logNum;
    }

    public void setLogNum(Integer logNum) {
        this.logNum = logNum;
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }
}
