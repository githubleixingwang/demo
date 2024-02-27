package com.demo.jar.service;

import com.demo.jar.controller.TicketController;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * @author: lxw
 * @date: 2023-07-27  13:51
 */

@Service
@Slf4j
public class TicketDiTieService {

    @Autowired
    private ResourceLoader resourceLoader;

    @Async("threadPoolExecutorTicket")
    public void ditie(String phone, String subway, String subwayStation, int num) {
        try {
            long tokenTime = System.currentTimeMillis();
            String url = "https://webui.mybti.cn/#/selecttime?lineName=" + subway + "&stationName=" + subwayStation;
            LocalTime time = LocalTime.now().withHour(12);
            LocalTime localTime = LocalTime.now();

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            if (localTime.isBefore(time)) {
                calendar.set(Calendar.HOUR_OF_DAY, 12);
            } else {
                calendar.set(Calendar.HOUR_OF_DAY, 20);
            }
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            Date date = calendar.getTime();
            //计算周几
            LocalDate today = LocalDate.now();
            int day = today.plusDays(1).getDayOfWeek().getValue();
            String targetTime = "";
            if (day > 5) {
                targetTime = DayEnum.getVal(1);
            } else {
                targetTime = DayEnum.getVal(day);
            }

            //获取jar的运行路径
            ApplicationHome home = new ApplicationHome(getClass());
            File jarFile = home.getSource();
            String classPath = jarFile.toString();
            String chromeDriverFilePath;
            log.error("classPath：" + classPath);
            //根据运行路径中是否包含.jar判断是jar包方式运行还是源码方式运行
            if (classPath.contains(".jar")) {
                //如果是打包，取exe文件的同级目录下去找浏览器驱动
                ClassPathResource classPathResource = new ClassPathResource("static/chrome/Application/chromedriver.exe");
                chromeDriverFilePath = classPathResource.getPath();
            } else {
                //如果是源码取编译路径下的浏览器驱动
                chromeDriverFilePath = resourceLoader.getResource("classpath:static/chrome/Application/chromedriver.exe").getURL().getPath();
               // chromeDriverFilePath = classPath + "/static/chrome/Application/chromedriver.exe";
            }
            log.error("path2：" + chromeDriverFilePath);
            if (chromeDriverFilePath.startsWith("file:")) {
                chromeDriverFilePath = chromeDriverFilePath.replace("file:", "");
            }
            //配置浏览器驱动位置（驱动.exe与浏览器.exe在同级目录）
            System.setProperty("webdriver.chrome.driver", chromeDriverFilePath);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized"); // open Browser in maximized mode
            options.addArguments("disable-infobars"); // disabling infobars
            options.addArguments("--disable-extensions"); // disabling extensions
            options.addArguments("--disable-gpu"); // applicable to windows os only
            options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
            options.addArguments("--no-sandbox"); // Bypass OS security model
            HashMap<String, String> mobileEmulation = new HashMap<>();//增加本行
            mobileEmulation.put("deviceName", "iPhone X");//这里是要使用的模拟器名称
            options.setExperimentalOption("mobileEmulation", mobileEmulation);//增加本行
            //options.setBinary(chromeFilePath);若驱动.exe与浏览器.exe不在同级目录，需要设置浏览器.exe位置
            WebDriver driver = new ChromeDriver(options);
            //2、输入网址
            driver.get("https://webui.mybti.cn/");
            WebDriverWait phonewait = new WebDriverWait(driver, 100);
            //设置手机号
            WebElement phoneElement = phonewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder='请输入手机号码']")));
            phoneElement.sendKeys(phone);
            Thread.sleep(1000);
            WebElement codeElement = phonewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),\"获取验证码\")]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", codeElement);

            Thread.sleep(60000);
            while (true) {
                //防止会话过期
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - tokenTime > 600000) {
                    tokenTime = currentTimeMillis;
                    driver.get(url);
                }
                //当前时间
                if (currentTimeMillis >= date.getTime()) {
                    WebDriverWait wait = new WebDriverWait(driver, 10);
                    for (int i = 0; i < 100; i++) {
                        driver.get(url);
                        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'" + targetTime + "')]/parent::div/parent::div/div[2]/div[" + num + "]/div[2]")));
                        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
                        boolean bool = isJudgingElement(driver, By.xpath("//button[contains(text(),\"确定\")]"));
                        if (bool) {
                            WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),\"确定\")]")));
                            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element2);
                            //scheduleUtil.cancelScheduledTask("ditie");
                            break;
                        }
                    }
                    TicketController.addition();
                    break;
                }
            }

        } catch (Exception e) {
            TicketController.addition();
            e.printStackTrace();
            //browser.quit();
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

    enum DayEnum {
        Monday(1, "周一"),
        Tuesday(2, "周二"),
        Wednesday(3, "周三"),
        Thursday(4, "周四"),
        Friday(5, "周五"),
        Saturday(6, "周六"),
        Sunday(7, "周日");
        private int name;
        private String val;

        DayEnum(Integer name, String val) {
            this.name = name;
            this.val = val;
        }

        public static String getVal(Integer name) {
            for (DayEnum day : DayEnum.values()) {
                if (day.getName() == name) {
                    return day.getVal();
                }
            }
            return "";
        }

        public Integer getName() {
            return name;
        }

        public String getVal() {
            return val;
        }

    }

}
