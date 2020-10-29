# springframework 注解缓存 使用演示

## 开启
```java
//加 @EnableCaching 注解开启缓存支持
@EnableCaching
@SpringBootApplication
public class CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheApplication.class, args);
    }

}
```

## 使用
```java
@Service
public class CacheService {

    private volatile String data = "";
    
    //开启缓存
    @Cacheable(value = "dataCache")
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    //清楚缓存
    @CacheEvict(value = "dataCache", allEntries = true, beforeInvocation = true)
    public void setClearData(String data) {
        this.data = data;
    }
}
```

## 调用
```java
class CacheServiceTest extends CacheApplicationTests {

    @Resource
    private CacheService cacheService;

    @Test
    public void cacheTest() {
        cacheService.setData("1");
        String data = cacheService.getData();
        System.out.println(data);
        System.out.println();
        Assertions.assertEquals("1", data);

        cacheService.setData("2");
        data = cacheService.getData();
        System.out.println(data);
        System.out.println();
        Assertions.assertEquals("1", data);

        cacheService.setClearData("2");
        data = cacheService.getData();
        System.out.println(data);
        System.out.println();
        Assertions.assertEquals("2", data);
    }
}
```




