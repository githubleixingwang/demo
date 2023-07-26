package com.demo.test.taobao;

import com.demo.test.util.scheduled.ScheduleUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;


@RestController
public class TaoBaoController {

    private static int num = 0;
    private static boolean end = false;
    private static WebDriver browser = null;

    @Resource
    private ScheduleUtil scheduleUtil;

    /**
     * 注意：1.chrome浏览器版本与浏览器驱动的版本一致 2.浏览器的购物车页面必须显示出你要加购商品的信息
     */
    @GetMapping("/taoBao")
    public void taoBao() {
        WebDriver browser = null;
        try {
            //设置秒杀时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSSSSSSSS");
            Date date = sdf.parse("2022-04-14 00:00:00 000000000");
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
            browser.get("https://www.taobao.com");
            Thread.sleep(2000);

            //3、点击登录
            browser.findElement(By.linkText("亲，请登录")).click();

            //browser.findElement(By.id("J_Quick2Static")).click(); //选择用密码登陆

            Thread.sleep(2000);

            /*browser.findElement(By.className("weibo-login")).click();//选择微博登陆

            Thread.sleep(5000);

            browser.findElement(By.name("username")).sendKeys("aaaaaaa");//aaaaaaa换为你的微博账号

            browser.findElement(By.name("password")).sendKeys("aaaaaaa");//aaaaaaa换为你的微博密码

            browser.findElement(By.className("W_btn_g")).click();//确认使用微博登陆*/

            browser.findElement(By.className("icon-qrcode")).click();//扫码登录


            Thread.sleep(4000);
            //4、扫码登录
            //System.out.println("请登录");
            //Thread.sleep(10000);

            //5、进入购物车页面
            browser.get("https://cart.taobao.com/cart.htm");
            Thread.sleep(2000);

            //6、定位商品，js点击事件选择商品
            WebDriverWait wait = new WebDriverWait(browser, 10);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"J_Item_4615960367680\"]/ul/li/div/div/div/label")));
            ((JavascriptExecutor) browser).executeScript("arguments[0].click();", element);
            Thread.sleep(2000);

            //7、到时间后进行结算
            while (true) {
                //当前时间
                Date now = new Date();
                System.out.println(now);
                if (now.after(date)) {
                    if (browser.findElement(By.linkText("结 算")).isEnabled()) {
                        browser.findElement(By.linkText("结 算")).click();
                        System.out.println("结算成功");
                        break;
                    }
                }
            }
            Thread.sleep(5000);
        } catch (Exception e) {
            //异常，关闭浏览器
            browser.quit();
            e.printStackTrace();
        }
    }


    @Scheduled(cron = "0 */1 * * * ?")
    public void ditie() {
        try {
            String url = "https://webui.mybti.cn/#/selecttime?lineName=昌平线&stationName=沙河站";
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
            this.num++;
            if (this.num == 1) {
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
                browser.get("https://webui.mybti.cn/");
            } else {
                browser.get(url);
                long l1 = System.currentTimeMillis();
                long l2 = date.getTime();
                if (l2 - l1 <= 60000) {
                    if (!end) {
                        while (true) {
                            //当前时间
                            Date now = new Date();
                            if (now.getTime() >= date.getTime()) {
                                WebDriverWait wait3 = new WebDriverWait(browser, 100);
                                for (int i = 0; i < 10; i++) {
                                    browser.get(url);
                                    WebElement element3 = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'" + targetTime + "')]/parent::div/parent::div/div[2]/div[7]/div[2]")));
                                    ((JavascriptExecutor) browser).executeScript("arguments[0].click();", element3);
                                    boolean bool = isJudgingElement(browser, By.xpath("//button[contains(text(),\"确定\")]"));
                                    if (bool) {
                                        WebDriverWait wait2 = new WebDriverWait(browser, 10);
                                        WebElement element2 = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),\"确定\")]")));
                                        ((JavascriptExecutor) browser).executeScript("arguments[0].click();", element2);
                                        //scheduleUtil.cancelScheduledTask("ditie");
                                        end = true;
                                        break;
                                    }
                                }
                            }
                            if (end) {
                                break;
                            }
                        }
                    }

                }
            }
        } catch (Exception e) {
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
