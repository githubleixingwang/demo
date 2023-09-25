package com.demo.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ScannerTest {

    public static volatile int count = 0;

    public static void main(String[] args) throws Exception {
       /* Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        StringBuilder stringBuilder = new StringBuilder(next);
        System.out.println("输入信息反向输出：" + stringBuilder.reverse());
        */
      /*  ExecutorService exe = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 1000; i++) {
            exe.execute(new Runnable() {
                @Override
                public void run() {

                    count++;
                    System.out.println(Thread.currentThread().getName() + ":" + count);


                }
            });
        }
        System.out.println(Thread.currentThread().getName() + ":" + count);*/

       /* AAAA b =new BBBB();
        AAAA c =new CCCC();
        b.a();c.a();*/
       /* String y = "RkEtMTYtM0UtMUQtQTMtMkI6djk6MTAwOm5vbmUsY29kZW5hbWUtY3NhLGNvZGVuYW1lLWxlYWRzZWMtY3NhLHJlc2VydmVkMSxyZXNlcnZlZDIscmVzZXJ2ZWQzLHJlc2VydmVkNCxyZXNlcnZlZDUscmVzZXJ2ZWQ2LHJlc2VydmVkNyxyZXNlcnZlZDgscmVzZXJ2ZWQ5LHJlc2VydmVkMTAscmVzZXJ2ZWQxMSxyZXNlcnZlZDEyLHJlc2VydmVkMTMscmVzZXJ2ZWQxNCxyZXNlcnZlZDE1LHJlc2VydmVkMTgscmVzZXJ2ZWQxOSxyZXNlcnZlZDIyLHJlc2VydmVkMjMscmVzZXJ2ZWQyNCxyZXNlcnZlZDI1LHJlc2VydmVkMjYscmVzZXJ2ZWQyNyxyZXNlcnZlZDI4LHJlc2VydmVkMjkscmVzZXJ2ZWQzMCxyZXNlcnZlZDMxLHJlc2VydmVkMzIscmVzZXJ2ZWQzMyxyZXNlcnZlZDM0LHJlc2VydmVkMzUscmVzZXJ2ZWQzNixyZXNlcnZlZDM3LHJlc2VydmVkMzgscmVzZXJ2ZWQzOSxyZXNlcnZlZDQwLHJlc2VydmVkNDEscmVzZXJ2ZWQ0MixyZXNlcnZlZDQzLHJlc2VydmVkNDQscmVzZXJ2ZWQ0NSxyZXNlcnZlZDQ2LHJlc2VydmVkNDcscmVzZXJ2ZWQ0OCxyZXNlcnZlZDQ5LHJlc2VydmVkNTA6dGVzdC3lqLTlrK3nmK86dHJpYWw=";
        byte[] bytes = Base64.getDecoder().decode(y.getBytes("gbk"));
        String s = new String(bytes, StandardCharsets.UTF_8);
        String s1 = new String(s.getBytes("gbk"), StandardCharsets.UTF_8);

        System.out.println(s);
        System.out.println(s1);
        System.out.println("==================");
        
        String iso8859 = new String(s1.toString().getBytes("iso8859-1"));
        String gbk = new String(s1.toString().getBytes("gbk"));
        String utf8 = new String(s1.toString().getBytes("utf-8"));
        if(iso8859.equals(s1.toString())){
            System.out.println("iso8859");
        }else  if(gbk.equals(s1.toString())){
            System.out.println("gbk");
        }else  if(utf8.equals(s1.toString())){
            System.out.println("utf8");
        }*/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        long curr = System.currentTimeMillis();
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(curr/1000*1000); // 忽略毫秒
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.add(Calendar.DATE,2);
        Date date1 = new Date(c.getTimeInMillis());
        System.out.println(sdf.format(date1));
        int yushu = c.get(Calendar.DATE)%10;
        while(yushu != 0){
            c.add(Calendar.DATE, -yushu);
            yushu = c.get(Calendar.DATE)%10;
        }
        if (c.get(Calendar.DATE) == 30){
            c.add(Calendar.DATE, -10);
        }
        Date date = new Date(c.getTimeInMillis());
        System.out.println(sdf.format(date));
    }


}
