package com.demo.test.base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 二进制与obj转换
 *
 * @author: lxw
 * @date: 2022-12-22  16:49
 */
public class ObjUtils {
    private static Logger logger = LoggerFactory.getLogger(ObjUtils.class);

    /**
     * obj转二进制
     *
     * @param obj
     * @return
     */
    public static byte[] obj2byte(Object obj) {
        try {
            ByteArrayOutputStream byam = new ByteArrayOutputStream();
            ObjectOutputStream oos = null;
            oos = new ObjectOutputStream(byam);
            oos.writeObject(obj);
            return byam.toByteArray();
        } catch (Exception e) {
            logger.error("obj转byte异常");
        }
        return null;
    }

    /**
     * 二进制转obj
     *
     * @param bytes
     * @return
     */
    public static Object byte2obj(byte[] bytes) {
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
            logger.error("byte转obj异常");
        }
        return null;
    }
}
