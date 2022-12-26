package com.demo.vue.test.io;

import java.io.*;

/**
 * io
 */
public class IoTest {


    /**
     * 字节输出流
     */
    public void outputStream() throws IOException {
        File file = new File("E:" + File.separator + "wk" + File.separator + "file-test" + File.separator + "字节输出流测试.docx");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        OutputStream fileOutputStream = new FileOutputStream(file, true);
        String data = "字节输出流测试，程序将数据输出至文档中";
        byte[] bytes = data.getBytes();
        fileOutputStream.write(bytes);
        fileOutputStream.close();
    }

    /**
     * 字节输入流
     */
    public void inputStream() throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        File file = new File("E:" + File.separator + "wk" + File.separator + "file-test" + File.separator + "字节输出流测试.docx");
        InputStream fileInputStream = new FileInputStream(file);
        byte data[] = new byte[1024];
        int temp;//接收每次保存的字节数据
        while ((temp = fileInputStream.read(data)) != -1) {
            stringBuffer.append(new String(data, 0, temp));
        }
        System.out.println("读取的内容【" + stringBuffer.toString() + "】");
        fileInputStream.close();
//
//        File outputFile = new File("E:" + File.separator + "wk" + File.separator + "file-test" + File.separator + "字节输出流测试重新写入.docx");
//        if (!outputFile.getParentFile().exists()) {
//            outputFile.getParentFile().mkdirs();
//        }
//        OutputStream fileOutputStream = new FileOutputStream(outputFile);
//        fileOutputStream.write(stringBuffer.toString().getBytes());
//        fileOutputStream.close();
    }

}
