package com.demo.test.taobao;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Kirk.Ke
 * @Description: 描述
 * @Date Created in 2022-04-08 15:41
 */
@RestController
public class TaoBaoController {

    @GetMapping("/taoBao")
    public void taoBao()  {
        WebDriver browser =null;
        try {
            //设置秒杀时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSSSSSSSS");
            Date date = sdf.parse("2022-04-14 14:07:00 000000000");

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
            Actions actions = new Actions(browser);
            //2、输入网址
            browser.get("https://www.taobao.com");
            Thread.sleep(3000);

            //3、点击登录
            browser.findElement(By.linkText("亲，请登录")).click();

            //browser.findElement(By.id("J_Quick2Static")).click(); //选择用密码登陆

            Thread.sleep(2000);

        /*browser.findElement(By.className("weibo-login")).click();//选择微博登陆

        Thread.sleep(5000);

        browser.findElement(By.name("username")).sendKeys("17683856100");//横线换为你的微博账号

        browser.findElement(By.name("password")).sendKeys("kl000111");//横线换为你的微博密码

        browser.findElement(By.className("W_btn_g")).click();//确认使用微博登陆*/
            browser.findElement(By.className("icon-qrcode")).click();//扫码登录


            Thread.sleep(4000);
            //4、扫码登录
            //System.out.println("请登录");
            //Thread.sleep(10000);


            //5、进入购物车页面
            browser.get("https://cart.taobao.com/cart.htm");
            Thread.sleep(3000);

            //6、点击选择第一个按钮
            //browser.findElement(By.xpath("//*[@id=\"J_Item_4059129296679\"]/ul/li/div/div/div/label")).click();
            //browser.findElement(By.xpath("//*[@id=\"J_Item_4059129296679\"]/ul/li/div/div/div/label")).sendKeys(Keys.ENTER);

            WebDriverWait wait = new WebDriverWait(browser, 10);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"J_Item_4059129296679\"]/ul/li/div/div/div/label")));
            ((JavascriptExecutor)browser).executeScript("arguments[0].click();", element);


            Thread.sleep(2000);
            while (true){
                //当前时间
                Date now = new Date();
                System.out.println(now);
                if(now.after(date)){
                    if(browser.findElement(By.linkText("结 算")).isEnabled()){
                        browser.findElement(By.linkText("结 算")).click();
                        System.out.println("结算成功");
                        break;
                    }

                }
            }
            Thread.sleep(5000);
        }catch (Exception e){
            browser.quit();
            e.printStackTrace();
        }

    }


}
