import com.demo.vue.service.BugServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.exceptions.base.MockitoException;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@DisplayName("我的第一个测试用例")
public class BugServiceImplTest {

     @Resource
     BugServiceImpl bugServiceImpl;

    @BeforeAll
    public static void init() {
        System.out.println("初始化数据");
    }

    @BeforeEach
    public void tearup() {
        System.out.println("当前测试方法开始");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("当前测试方法结束");
    }

    @AfterAll
    public static void cleanup() {
        System.out.println("清理数据");
    }



}