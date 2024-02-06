package com.demo.jar.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author: lxw
 * @date: 2024-02-06  13:59
 */
public class XpathUtils {
    /**
     * 下滑动到某个元素出现，需传入element
     */
    public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
    }

    /**
     * 下滑动到某个元素出现，需传入定位元素所需的xpath表达式
     */
    public static void scrollToElement(WebDriver driver, String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
    }

    /**
     * 局部自定义滑动
     *
     * @param ClassName class的值,需要定位到滑动的元素
     * @param num       获取元素结果可能为多个，取第num个元素
     * @param width     width表示滑动距离为整个页面宽度的width倍，注意width值应在[0,1]内，0表示最左边，1表示最右边
     * @param height    height表示滑动距离为整个页面高度的height倍，注意height值应在[0,1]内，0表示顶部，1表示底部
     */
    public static void scrollGustomizedPart(WebDriver driver, String ClassName, int num, String width, String height) {
        num--;
        ((JavascriptExecutor) driver).executeScript("document.getElementsByClassName(\"" + ClassName + "\")[" + num + "].scrollBy" + "(document.getElementsByClassName(\"" + ClassName + "\")[" + num + "].scrollWidth*" + width + "," + "document.getElementsByClassName(\"" + ClassName + "\")[" + num + "].scrollHeight*" + height + ")");
    }

    /**
     * 局部滑动到最右边
     *
     * @param ClassName class的值,需要定位到滑动的元素
     * @param num       获取元素结果可能为多个，取第num个元素
     */
    public static void scrollToRightPart(WebDriver driver, String ClassName, int num) {
        scrollGustomizedPart(driver, ClassName, num, "1", "0.5");
    }

    /**
     * 局部滑动到最左边
     *
     * @param ClassName class的值,需要定位到滑动的元素
     * @param num       获取元素结果可能为多个，取第num个元素
     */
    public static void scrollToLeftPart(WebDriver driver, String ClassName, int num) {
        scrollGustomizedPart(driver, ClassName, num, "0", "0.5");
    }

    /**
     * 局部滑动到顶部
     *
     * @param ClassName class的值,需要定位到滑动的元素
     * @param num       获取元素结果可能为多个，取第num个元素
     */
    public static void scrollToTopPart(WebDriver driver, String ClassName, int num) {
        scrollGustomizedPart(driver, ClassName, num, "0.5", "0");
    }

    /**
     * 局部滑动到底部
     *
     * @param ClassName class的值,需要定位到滑动的元素
     * @param num       获取元素结果可能为多个，取第num个元素
     */
    public static void scrollToBottomPart(WebDriver driver, String ClassName, int num) {
        scrollGustomizedPart(driver, ClassName, num, "0.5", "1");
    }

    /**
     * 全局自定义滑动
     *
     * @param width  width表示滑动距离为整个页面宽度的width倍，注意width值应在[0,1]内，0表示最左边，1表示最右边
     * @param height height表示滑动距离为整个页面高度的height倍，注意height值应在[0,1]内，0表示顶部，1表示底部
     */
    public static void scrollGustomized(WebDriver driver, String width, String height) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollWidth*" + width + ",document.body.scrollHeight*" + height + ");");
    }

    /**
     * 全局横向滑动到指定宽度(水平滚动)
     * scale表示滑动距离为整个页面宽度的scale倍，注意scale值应在[0,1]内，0表示最左边，1表示最右边
     */
    public static void scrollLevel(WebDriver driver, String scale) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollWidth*" + scale + ",document.body.scrollHeight/2);");
    }

    /**
     * 全局滑动到最右边
     */
    public static void scrollToRight(WebDriver driver) {
        scrollLevel(driver, "1");
    }

    /**
     * 全局滑动到最左边
     */
    public static void scrollToLeft(WebDriver driver) {
        scrollLevel(driver, "0");
    }

    /**
     * 全局纵向滑动到指定高度(垂直滚动)
     * scale表示滑动距离为整个页面高度的scale倍，注意scale值应在[0,1]内，0表示顶部，1表示底部
     */
    public static void scrollVertical(WebDriver driver, String scale) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollWidth/2,document.body.scrollHeight*" + scale + ");");
    }

    /**
     * 全局滑动到底部
     */
    public static void scrollToBottom(WebDriver driver) {
        scrollVertical(driver, "1");
    }

    /**
     * 全局滑动到顶部
     */
    public static void scrollToTop(WebDriver driver) {
        scrollVertical(driver, "0");
    }

}
