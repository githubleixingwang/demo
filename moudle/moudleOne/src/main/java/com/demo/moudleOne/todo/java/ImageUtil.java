package com.demo.moudleOne.todo.java;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImageUtil {

    private static final String RANDOMCOOEKEY = "RANDOMCOOEKEY";
    private int width = 95;
    private int height = 25;
    private int stringNum = 4;
    private int lineSize = 40;
    private static String randString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String randInt = "1234567890";
    private static String randStringInt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final Logger logger = LoggerFactory.getLogger(ImageUtil.class);
    private Random random = new Random();

    public ImageUtil() {
    }

    private Font getFont() {
        return new Font("Fixedsys", 1, 18);
    }

    private Color getRandColor(int fc, int bc) {
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }

        int r = fc + this.random.nextInt(bc - fc - 16);
        int g = fc + this.random.nextInt(bc - fc - 14);
        int b = fc + this.random.nextInt(bc - fc - 18);
        return new Color(r, g, b);
    }

    private int getXPosition4Twist(double dPhase, double dMultValue, int height, int xPosition, int yPosition) {
        double PI = 3.141592653589793D;
        double dx = PI * (double) yPosition / (double) height + dPhase;
        double dy = Math.sin(dx);
        return xPosition + (int) (dy * dMultValue);
    }

    public void getRandCode(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        BufferedImage image = new BufferedImage(this.width, this.height, 4);
        Graphics g = image.getGraphics();
        g.fillRect(0, 0, this.width, this.height);
        g.setFont(new Font("Times New Roman", 0, 18));
        g.setColor(this.getRandColor(110, 133));
        if (this.lineSize > 0) {
            for (int i = 0; i <= 300 && i <= this.lineSize; ++i) {
                this.drowLine(g);
            }
        }

        String randomString = "";
        if (this.stringNum > 0) {
            for (int i = 1; i <= 300 && i <= this.stringNum; ++i) {
                randomString = this.drowString(g, randomString, i);
            }
        }

        session.removeAttribute("RANDOMCOOEKEY");
        session.setAttribute("RANDOMCOOEKEY", randomString);
        double dMultValue = (double) (this.random.nextInt(2) + 6);
        double dPhase = (double) this.random.nextInt(7);
        BufferedImage destBi = new BufferedImage(image.getWidth(), image.getHeight(), 1);
        if (destBi != null && destBi.getWidth() > 0) {
            for (int i = 0; i < destBi.getWidth() && i < destBi.getWidth(); ++i) {
                if (destBi != null && destBi.getHeight() > 0) {
                    for (int j = 0; j < destBi.getHeight() && j < destBi.getHeight(); ++j) {
                        int nOldX = this.getXPosition4Twist(dPhase, dMultValue, destBi.getHeight(), i, j);
                        if (nOldX >= 0 && nOldX < destBi.getWidth() && j >= 0 && j < destBi.getHeight()) {
                            destBi.setRGB(nOldX, j, image.getRGB(i, j));
                        }
                    }
                }
            }
        }

        g.dispose();

        try {
            ImageIO.write(destBi, "JPEG", response.getOutputStream());
        } catch (Exception var16) {
            logger.error("生成图片验证码输出到客户端失败!");
        }

    }

    public String drowString(Graphics g, String randomString, int i) {
        g.setFont(this.getFont());
        g.setColor(new Color(this.random.nextInt(101), this.random.nextInt(111), this.random.nextInt(121)));
        String rand = null;
        if (i == 1) {
            rand = String.valueOf(this.getRanddomString(this.random.nextInt(randString.length()), randString));
        } else if (i == 2) {
            rand = String.valueOf(this.getRanddomString(this.random.nextInt(randInt.length()), randInt));
        } else {
            rand = String.valueOf(this.getRanddomString(this.random.nextInt(randStringInt.length()), randStringInt));
        }

        randomString = randomString + rand;
        g.translate(this.random.nextInt(3), this.random.nextInt(5));
        g.drawString(rand, 13 * i, 16);
        return randomString;
    }

    private void drowLine(Graphics g) {
        int x = this.random.nextInt(this.width);
        int y = this.random.nextInt(this.height);
        int xl = this.random.nextInt(13);
        int yl = this.random.nextInt(15);
        g.drawLine(x, y, x + xl, y + yl);
    }

    public String getRanddomString(int num, String randString) {
        return String.valueOf(randString.charAt(num));
    }


}
