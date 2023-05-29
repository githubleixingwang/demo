package com.appleyk.DMB17_责任链模式.Handler;

import java.util.List;

import com.appleyk.DMB17_责任链模式.DM17.AbstractHandler;
import com.appleyk.DMB17_责任链模式.DM17.filter.ComputerFilter;
import com.appleyk.DMB17_责任链模式.DM17.model.Computer;
import com.appleyk.DMB17_责任链模式.DM17.model.Keyboard;

/**
 * <p>键盘处理事件</p>
 *
 * @author Appleyk
 * @version v0.1.1
 * @blob https://blog.csdn.net/appleyk
 * @date Created on 下午 1:26 2018-11-7
 */
public class KeyboardHandler extends AbstractHandler<List<Computer>, ComputerFilter> {

    @Override
    public List<Computer> filter(ComputerFilter filter) {
        List<Computer> computers = this.getData();
        Boolean loadKeyboard = filter.getLoadKeyboard();
        if (loadKeyboard) {
            for (Computer computer : computers) {
                Keyboard keyboard = new Keyboard("无线");
                keyboard.setId(idsMaker.nextId());
                keyboard.setName("雷柏键盘");
                computer.setKeyboard(keyboard);
            }
        }
        return computers;
    }
}
