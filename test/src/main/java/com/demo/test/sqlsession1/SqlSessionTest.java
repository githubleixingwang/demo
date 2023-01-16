package com.demo.test.sqlsession1;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;


/**
 * @author: lxw
 * @date: 2023-01-16  10:27
 */
@Slf4j
@Component
public class SqlSessionTest {

    @Autowired
    private SqlContext sqlContext;

    /**
     * 测试多线程事务
     */
    public void saveThread() throws SQLException {
        List<EmployeeDO> employeeDOList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            employeeDOList.add(new EmployeeDO());
        }
        // 获取数据库连接,获取会话(内部自有事务)
        SqlSession sqlSession = sqlContext.getSqlSession();
        Connection connection = sqlSession.getConnection();
        try {
            // 设置手动提交
            connection.setAutoCommit(false);
            //获取mapper
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            //先做删除操作
            //employeeMapper.delete("null");

            // 获取执行器
            ExecutorService exec = ExecutorConfig.getThreadPool();
            List<Callable<Integer>> callableList = new ArrayList<Callable<Integer>>();
            // 拆分list
            List<List<EmployeeDO>> lists = averageAssign(employeeDOList, 5);
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            for (int i = 0; i < lists.size(); i++) {
                List<EmployeeDO> list = lists.get(i);
                //将任务放入callable线程中，runnable没有返回值，callable有返回值
                Callable<Integer> callable = () -> employeeMapper.saveBatch(list);
                callableList.add(callable);
            }
//            1、invallkeAll和invokeAny会直接造成主线程阻塞（需要设置超时时间）。等待所有任务执行完成后返回结果，主线程继续执行；有返回值
//            2、submit不会造成主线程阻塞，在后面执行get方法的时候阻塞。超时时间在get里面设置；有返回值
//            3、execute会新开启线程直接执行任务，不会阻塞主线程。；无返回值
            //执行子线程
            List<Future<Integer>> futures = exec.invokeAll(callableList);
            for (Future<Integer> future : futures) {
                //如果有一个执行不成功,则全部回滚
                if (future.get() <= 0) {
                    connection.rollback();
                    return;
                }
            }
            connection.commit();
            log.info("添加完毕");
        } catch (Exception e) {
            connection.rollback();
            log.error("error", e);
            throw new SQLException("001", "出现异常");
        } finally {
            connection.close();
        }
    }

    /**
     * 平均拆分list
     */
    public static <T> List<List<T>> averageAssign(List<T> source, int n) {
        List<List<T>> result = new ArrayList<List<T>>();
        int remaider = source.size() % n;
        int number = source.size() / n;
        int offset = 0;//偏移量
        for (int i = 0; i < n; i++) {
            List<T> value = null;
            if (remaider > 0) {
                value = source.subList(i * number + offset, (i + 1) * number + offset + 1);
                remaider--;
                offset++;
            } else {
                value = source.subList(i * number + offset, (i + 1) * number + offset);
            }
            result.add(value);
        }
        return result;
    }

}
