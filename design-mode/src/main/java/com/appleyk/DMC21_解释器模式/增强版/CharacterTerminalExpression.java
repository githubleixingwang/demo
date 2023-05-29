package com.appleyk.DMC21_解释器模式.增强版;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>字符终端表达式</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date created on 2022/10/16:21:39
 */
@Data
@NoArgsConstructor
public class CharacterTerminalExpression implements IExpression{
    private Set<String> chars;
    public CharacterTerminalExpression(String[] array){
        this.chars = array == null ? new HashSet<>() : new HashSet<>(Arrays.asList(array));
    }
    /**判断是否包含某个字符*/
    @Override
    public boolean interpret(String character) {
        return CollectionUtils.isEmpty(chars) ? false : chars.contains(character);
    }

}
