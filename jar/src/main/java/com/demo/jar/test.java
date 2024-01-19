package com.demo.jar;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author: lxw
 * @date: 2024-01-12  18:36
 */
public class test {
    public static void main(String[] args) throws Exception {
         long begin = 33112001;//起始id
         long end = begin+100000;//每次循环插入的数据量
         String url = "jdbc:mysql://localhost:3308/tsoc?useServerPrepStmts=false&rewriteBatchedStatements=true&useUnicode=true&amp;characterEncoding=UTF-8";
         String user = "root";
         String password = "venustech.tsoc.db.ROOT";


            //定义连接、statement对象
            Connection conn = null;
            PreparedStatement pstm = null;
            try {
                //加载jdbc驱动
                Class.forName("com.mysql.jdbc.Driver");
                //连接mysql
                conn = DriverManager.getConnection(url, user, password);
                //将自动提交关闭
                // conn.setAutoCommit(false);
                //编写sql
                String sql = "INSERT INTO zd_linux_202411 VALUES (?,?,?,?,?,?,?,?)";
                //预编译sql
                pstm = conn.prepareStatement(sql);
                //开始总计时
                long bTime1 = System.currentTimeMillis();

                //循环10次，每次十万数据，一共1000万
                for(int i=0;i<1000;i++) {

                    //开启分段计时，计1W数据耗时
                    long bTime = System.currentTimeMillis();
                    //开始循环
                    while (begin < end) {
                        //赋值
                        pstm.setLong(1, begin);
                        pstm.setInt(2, 365729091);
                        pstm.setInt(3, 1);
                        pstm.setInt(4, 0);
                        pstm.setFloat(5, 680);
                        pstm.setString(6, null);
                        pstm.setInt(7, -1);
                        pstm.setLong(8, bTime);
                        //添加到同一个批处理中
                        pstm.addBatch();
                        begin++;
                    }
                    //执行批处理
                    pstm.executeBatch();
                    //提交事务
                    //        conn.commit();
                    //边界值自增10W
                    end += 100000;
                    //关闭分段计时
                    long eTime = System.currentTimeMillis();
                    //输出
                    System.out.println("成功插入10W条数据耗时："+(eTime-bTime));
                }
                //关闭总计时
                long eTime1 = System.currentTimeMillis();
                //输出
                System.out.println("插入100W数据共耗时："+(eTime1-bTime1));
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }

    }
}
