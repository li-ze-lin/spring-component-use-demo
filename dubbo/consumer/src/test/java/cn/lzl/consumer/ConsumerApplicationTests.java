package cn.lzl.consumer;

import cn.lzl.client.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsumerApplicationTests {

    @DubboReference
    private DemoService demoService;

    @Test
    void consumerTest() {
        String test = demoService.print("test");
        System.out.println(test);
    }

}
