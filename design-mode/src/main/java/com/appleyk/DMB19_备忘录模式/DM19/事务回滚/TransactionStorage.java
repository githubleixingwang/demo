package com.appleyk.DMB19_备忘录模式.DM19.事务回滚;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>事务存储类，每一个事务的提交日志都存储在该类中</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date Created on 下午 1:05 2018-11-21
 */
public class TransactionStorage {

    private Map<Integer, TransactionJournal> logMap = new HashMap<>();

    public TransactionStorage(TransactionJournal journal) {
        logMap.put(journal.getLogNum(), journal);
    }

    /**
     * <p>根据事务日志ID获取对应的事务日志</p>
     *
     * @param logNum 事务日志ID
     * @return 事务日志对象
     */
    public TransactionJournal getLogMap(Integer logNum) {
        return logMap.get(logNum);
    }

    public void setLogMap(Map<Integer, TransactionJournal> logMap) {
        this.logMap = logMap;
    }

    public void backup(TransactionJournal journal) {
        this.logMap.put(journal.getLogNum(), journal);
    }
}
