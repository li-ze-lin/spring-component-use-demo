# 将配置绑定到实体

## 读取默认配置文件

```properties
my.name=lzl
my.describe=describe
```

```java
/**
 * 读取默认配置文件内的值
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "my")
public class MyConfiguration {
    private String name;
    private String describe;

}
```

## 读取非默认配置文件

```properties
my.extra.name=extra-name
my.extra.describe=extra-describe
``` 

```java
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "my.extra")
@PropertySource(value = "classpath:extra.properties")
public class ExtraConfiguration {
    private String name;
    private String describe;
}
```

## 验证
```java
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
```
