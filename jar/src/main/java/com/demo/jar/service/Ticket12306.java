package com.demo.jar.service;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lxw
 * @date: 2023-07-20  16:13
 */

@RestController
public class Ticket12306 {
    private static WebDriver browser = null;
    private static boolean flag = true;
    private static boolean end = false;

   // @Scheduled(cron = "0 */1 * * * ?")
    public void ticket() {
        try {
            if (flag) {
                //配置浏览器驱动位置（驱动.exe与浏览器.exe在同级目录）
                System.setProperty("webdriver.chrome.driver", "D:\\chrome\\ChromeCore\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized"); // open Browser in maximized mode
                options.addArguments("disable-infobars"); // disabling infobars
                options.addArguments("--disable-extensions"); // disabling extensions
                options.addArguments("--disable-gpu"); // applicable to windows os only
                options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
                options.addArguments("--no-sandbox"); // Bypass OS security model
                options.setBinary("D:\\chrome\\ChromeCore\\ChromeCore.exe");
                browser = new ChromeDriver(options);
                //2、输入网址
                browser.get("https://kyfw.12306.cn/otn/resources/login.html");
                Thread.sleep(2000);
                Thread.sleep(2000);
                browser.findElement(By.linkText("账号登录")).click();
                browser.findElement(By.id("J-userName")).sendKeys("15232109667");
                browser.findElement(By.id("J-password")).sendKeys("XINGWANG525");//aaaaaaa换为你的微博密码
                browser.findElement(By.linkText("立即登录")).click();
                Thread.sleep(2000);
                browser.findElement(By.id("id_card")).sendKeys("6319");//aaaaaaa换为你的微博密码
                Thread.sleep(2000);
                browser.findElement(By.id("verification_code")).click();
                flag = false;
            } else {
                String click = "arguments[0].click();";
                //查询条件
                browser.get("https://kyfw.12306.cn/otn/leftTicket/init?linktypeid=dc");
                browser.findElement(By.name("leftTicketDTO.from_station_name")).clear();
                browser.findElement(By.name("leftTicketDTO.to_station_name")).clear();
                browser.findElement(By.id("train_date")).clear();

                browser.findElement(By.name("leftTicketDTO.from_station_name")).click();
                browser.findElement(By.name("leftTicketDTO.from_station_name")).sendKeys("北京");
                WebDriverWait wait = new WebDriverWait(browser, 5);
                WebElement elementFrom = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='ralign'  and text()='北京']")));
                ((JavascriptExecutor) browser).executeScript(click, elementFrom);

                browser.findElement(By.name("leftTicketDTO.to_station_name")).click();
                browser.findElement(By.name("leftTicketDTO.to_station_name")).sendKeys("正定机场");
                WebElement elementTo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='ralign'  and text()='正定机场']")));
                ((JavascriptExecutor) browser).executeScript(click, elementTo);

                browser.findElement(By.id("train_date")).sendKeys("2024-02-08");
                browser.findElement(By.id("query_ticket")).click();

                //预订的xpath
                String yudingXpath = "//a[contains(text(),'G7813')]/parent::div/parent::div/parent::div/parent::td/parent::tr/td[13]/a[contains(text(),'预订')]";
                //乘车人
                String user = "//label[contains(text(),'贾玲玲')  ]/preceding-sibling::input[@allencstr]";
                //席别
                String zuo = "//option[contains(text(),'二等')]";
                //确认订单
                String check = "//div[contains(text(),'请核对以下信息')]";
                //提交叮订单
                String submit = "//a[ @id  = 'qr_submit_id' ]";

                while (true) {
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