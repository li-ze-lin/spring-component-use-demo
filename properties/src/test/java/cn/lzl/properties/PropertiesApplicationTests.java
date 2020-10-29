package cn.lzl.properties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class PropertiesApplicationTests {

    @Resource
    private MyConfiguration myConfiguration;
    @Resource
    private ExtraConfiguration extraConfiguration;

    @Test
    void contextLoads() {
        Assertions.assertEquals(myConfiguration.getName(), "lzl");
        Assertions.assertEquals(myConfiguration.getDescribe(), "describe");
        Assertions.assertEquals(extraConfiguration.getName(), "extra-name");
        Assertions.assertEquals(extraConfiguration.getDescribe(), "extra-describe");
    }
}
