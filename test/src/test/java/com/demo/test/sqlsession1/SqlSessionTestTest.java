package com.demo.test.sqlsession1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.sql.SQLException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SqlSessionTestTest {

    @Autowired
    private SqlSessionTest sqlSessionTest;

    @Test
    public void saveThread() throws SQLException {
        sqlSessionTest.saveThread();
    }

}