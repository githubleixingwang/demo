package com.demo.test.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpSocketServer {

    /**
     * 服务端程序
     */
    public void server() throws IOException {
        try {
            ServerSocket server = new ServerSocket(2222);
            while (true){
                Socket socket = server.accept();

                InputStreamReader in = new InputStreamReader(socket.getInputStream());
                BufferedReader br =  new BufferedReader(in);
                FileWriter fw = new FileWriter("e:/log.txt",true); //写入路径
                fw.write("消息记录");
                fw.write("\r\n");//换行
                String content;

                while ((content = br.readLine()) != null && !"".equals(content)){
                    System.out.println("客户端发送的数据:"+content);
                }
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                String body = "hello,nio1";
                printWriter.println(body);
                printWriter.close();
                socket.close();
                fw.close();
            }        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) throws IOException {
        TcpSocketServer tcpSocketServer = new TcpSocketServer();
        tcpSocketServer.server();;
    }
}
