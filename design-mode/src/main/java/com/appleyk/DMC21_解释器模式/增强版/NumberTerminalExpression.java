package com.appleyk.DMC21_解释器模式.增强版;

import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>数字终端表达式（这里主要判断数字是否是10以下且是偶数）</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 2022/10/16:21:49
 */
public class NumberTerminalExpression implements IExpression{
    private Set<String> nums;
    public NumberTerminalExpression(String[] array){
        this.nums = array == null ? new HashSet<>() : new HashSet<>(Arrays.asList(array));
    }
    /**判断是number是否是>=1 且 <=10 且是偶数！*/
    @Override
    public boolean interpret(String number) {
        if (number == null){
            return false;
        }
        return CollectionUtils.isEmpty(nums) ? false : nums.contains(number)
                && ((Integer.valueOf(number) & 1) ==0);
    }
}
