package com.appleyk.DMB17_责任链模式.DM17.filter;

import lombok.Data;

import java.util.HashSet;

/**
 * <p>抽象过滤器</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date Created on 下午 2:11 2018-11-6
 */
@Data
//@NoArgsConstructor
public abstract class AbstractFilter {

    /**
     * 根据ids查询
     */
    private HashSet<Long> ids = new HashSet<>();

    /**
     * 根据names查询
     */
    private HashSet<String> names = new HashSet<>();

    private Integer pageNum = 1;
    private Integer pageSize = 10;

    public void addIds(Long id) {
        this.ids.add(id);
    }

}
