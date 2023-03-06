package com.demo.test.util.img;

import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: lxw
 * @date: 2023-02-27  10:33
 */
public class ImgUtil {


    /**
     * 提取富文本中img标签中src信息
     *
     * @param htmlStr 富文本
     * @return
     */
    public static List<String> getImgStr(String htmlStr) {
        List<String> list = new ArrayList<>();
        String img = "";
        Pattern p_image;
        Matcher m_image;
        // String regEx_img = "<img.*src=(.*?)[^>]*?>"; //图片链接地址
        String regEx_img = "<img.*src\\s*=\\s*(.*?)[^>]*?>";
        p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
        m_image = p_image.matcher(htmlStr);
        while (m_image.find()) {
            // 得到<img />数据
            img = m_image.group();
            // 匹配<img>中的src数据
            Matcher m = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);
            while (m.find()) {
                list.add(m.group(1));
            }
        }
        return list;
    }

    /**
     * base64图片数据转MultipartFile对象
     *
     * @param base64
     * @return
     */
    public static MultipartFile base64ToMultipartFile(String base64) {
        String[] baseStrs = base64.split(","); //base64编码后的图片有头信息所以要分离出来   [0]data:image/png;base64, 图片内容为索引[1]
        byte[] b = new byte[0];
        try {
            b = Base64.getDecoder().decode(baseStrs[1]);//取索引为1的元素进行处理
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < b.length; ++i) {
            if (b[i] < 0) {
                b[i] += 256;
            }
        }
        return new Base64DecodeMultipartFile(b, baseStrs[0]);//处理过后的数据通过Base64DecodeMultipartFile转换为MultipartFile对象
    }

    /**
     * 将图片inputstream流转为Base64
     *
     * @param is
     * @return
     * @throws Exception
     */
    public static String inputStream2Base64(InputStream is) throws Exception {
        byte[] data = null;
        try {
            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            byte[] buff = new byte[100];
            int rc = 0;
            while ((rc = is.read(buff, 0, 100)) > 0) {
                swapStream.write(buff, 0, rc);
            }
            data = swapStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    throw new Exception("输入流关闭异常");
                }
            }
        }

        return Base64.getEncoder().encodeToString(data);
    }

}
