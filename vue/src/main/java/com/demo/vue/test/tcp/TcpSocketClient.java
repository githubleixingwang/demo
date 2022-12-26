package com.demo.vue.test.tcp;

import java.io.*;
import java.net.Socket;

/**
 * @author: lxw
 * @date: 2022-12-07  09:49
 */
public class TcpSocketClient {
    public static void main(String[] args) {
        //创建客户端socket建立连接，指定服务器地址和端口
        try {
            //Socket socket = new Socket("www.jianshu.com",80);
            Socket socket = new Socket("127.0.0.1",2222);
            //获取输出流，向服务器端发送信息
            OutputStream outputStream = socket.getOutputStream();//字节输出流
            PrintWriter pw = new PrintWriter(outputStream); //将输出流包装为打印流
            pw.write("用户名：admin;密码：123");
            pw.flush();
            socket.shutdownOutput();

            //获取输入流，读取服务器端的响应
            InputStream inputStream = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String info = null;
            while((info = br.readLine())!=null){
                System.out.println("服务端返回信息:"+info);
            }
            socket.shutdownInput();

            //关闭资源
            br.close();
            inputStream.close();
            pw.close();
            outputStream.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
