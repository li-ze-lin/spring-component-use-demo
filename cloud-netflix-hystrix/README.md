# spring cloud netflix hystrix 使用演示

## 基于springboot的基础上引入
```xml
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
</dependency>
```

## 加上@EnableCircuitBreaker开启
```java
@EnableCircuitBreaker
@SpringBootApplication
public class HystrixApplication {
	public static void main(String[] args) {
		SpringApplication.run(HystrixApplication.class, args);
	}
}
```

## 在被调用service的方法上加上@HystrixCommand(fallbackMethod = "fail_callback_method")
```java
@Service
public class HystrixService {

    @HystrixCommand(fallbackMethod = "failFallbackMethod")
    public String fail() {
        throw new RuntimeException();
    }

    public String failFallbackMethod() {
        return "failFallbackMethod";
    }
}
```

##  调用
```java
@RestController
@RequestMapping
public class ApiController {

    @Resource
    private HystrixService hystrixService;

    @GetMapping
    public String fail() {
        return hystrixService.fail();
    }
}
```

## 结果
请求:http://127.0.0.1:11111

返回:failFallbackMethod
