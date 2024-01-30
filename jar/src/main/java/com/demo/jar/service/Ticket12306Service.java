package com.demo.jar.service;

import com.demo.jar.vo.Ticket12306Vo;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author: lxw
 * @date: 2024-01-25  10:12
 */
@Service
public class Ticket12306Service {

    @Async("threadPoolExecutorTicket")
    public void ticket12306(Ticket12306Vo vo) {
        try {
            //1.配置浏览器驱动位置（驱动.exe与浏览器.exe在同级目录）
            System.setProperty("webdriver.chrome.driver", "D:\\chrome\\ChromeCore\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized"); // open Browser in maximized mode
            options.addArguments("disable-infobars"); // disabling infobars
            options.addArguments("--disable-extensions"); // disabling extensions
            options.addArguments("--disable-gpu"); // applicable to windows os only
            options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
            options.addArguments("--no-sandbox"); // Bypass OS security model
            options.setBinary("D:\\chrome\\ChromeCore\\ChromeCore.exe");
            WebDriver browser = new ChromeDriver(options);
            //2、登录
            browser.get("https://kyfw.12306.cn/otn/resources/login.html");
            Thread.sleep(2000);
            Thread.sleep(2000);
            browser.findElement(By.linkText("账号登录")).click();
            browser.findElement(By.id("J-userName")).sendKeys(vo.getPhone());//账号
            browser.findElement(By.id("J-password")).sendKeys(vo.getPsw());//密码
            browser.findElement(By.linkText("立即登录")).click();
            Thread.sleep(2000);
            browser.findElement(By.id("id_card")).sendKeys(vo.getIdCard());//身份证后四位
            Thread.sleep(2000);
            browser.findElement(By.id("verification_code")).click();
            Thread.sleep(120000);//2分钟内输入短信验证码
            String click = "arguments[0].click();";
            Thread.sleep(10000);

            //3.查询车票信息
            browser.get("https://kyfw.12306.cn/otn/leftTicket/init?linktypeid=dc");
            Thread.sleep(5000);
            browser.findElement(By.name("leftTicketDTO.from_station_name")).clear();
            browser.findElement(By.name("leftTicketDTO.to_station_name")).clear();
            browser.findElement(By.id("train_date")).clear();
            Thread .sleep(2000) ;
            browser.findElement(By.name("leftTicketDTO.from_station_name")).click();
            browser.findElement(By.name("leftTicketDTO.from_station_name")).sendKeys(vo.getStart());
            WebDriverWait wait = new WebDriverWait(browser, 5);
            WebElement elementFrom = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='ralign'  and text()='" + vo.getStart() + "']")));
            ((JavascriptExecutor) browser).executeScript(click, elementFrom);
            browser.findElement(By.name("leftTicketDTO.to_station_name")).click();
            browser.findElement(By.name("leftTicketDTO.to_station_name")).sendKeys(vo.getEnd());
            WebElement elementTo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='ralign'  and text()='" + vo.getEnd() + "']")));
            ((JavascriptExecutor) browser).executeScript(click, elementTo);
            browser.findElement(By.id("train_date")).sendKeys(vo.getTravelTtime());
            //查询车票按钮
            browser.findElement(By.id("query_ticket")).click();
            //预订按钮
            String yudingXpath = "//a[contains(text(),'" + vo.getTrainNumber() + "')]/parent::div/parent::div/parent::div/parent::td/parent::tr/td[13]/a[contains(text(),'预订')]";
            //乘车人
            String user = "//label[contains(text(),'" + vo.getPassenger() + "')  ]/preceding-sibling::input[@allencstr]";
            //席别
            String zuo = "//option[contains(text(),'" + vo.getSeats() + "')]";
            //确认订单
            String check = "//div[contains(text(),'请核对以下信息')]";
            //提交订单
            String submit = "//a[ @id  = 'qr_submit_id' ]";

            while (true) {
                Thread.sleep(500);
                browser.findElement(By.id("query_ticket")).click();
                boolean bool = isJudgingElement(browser, By.xpath(yudingXpath));
                if (bool) {
                    //根据车次获取元素
                    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(yudingXpath)));
                    ((JavascriptExecutor) browser).executeScript(click, element);
                    while (true) {
                        boolean isUser = isJudgingElement(browser, By.xpath(user));
                        if (isUser) {
                            //乘车人
                            WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(user)));
                            ((JavascriptExecutor) browser).executeScript(click, element1);
                            //席别
                            WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(zuo)));

                            ((JavascriptExecutor) browser).executeScript(click, element2);
                            //提交订单
                            browser.findElement(By.id("submitOrder_id")).click();
                            while (true) {
                                boolean isCheck = isJudgingElement(browser, By.xpath(check));
                                if (isCheck) {
                                    //确认订单
                                    while (true) {
                                        boolean isSubmit = isJudgingElement(browser, By.xpath(submit));
                                        if (isSubmit) {
                                            WebElement end = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(submit)));
                                            ((JavascriptExecutor) browser).executeScript(click, end);
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断某个元素是否存在
     */
    public boolean isJudgingElement(WebDriver webDriver, By by) {
        try {
            webDriver.findElement(by);
            return true;
        } catch (Exception e) {
            System.out.println("不存在此元素");
            return false;
        }
    }

}
