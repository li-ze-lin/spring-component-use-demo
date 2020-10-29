# springframework jms(activemq) 使用演示

## 引入
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-activemq</artifactId>
</dependency>
```

## 使用
```java
@SpringBootApplication
public class JmsApplication implements CommandLineRunner {

    @Resource
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        SpringApplication.run(JmsApplication.class, args);
    }

    /**
     * 生产者
     */
    @Override
    public void run(String... args) throws Exception {
        jmsTemplate.send("sendMsg", session -> session.createTextMessage("msg"));
    }

    /**
     * 消费者
     */
    @JmsListener(destination = "sendMsg")
    public void listener(String msg) {
        System.out.println(msg);
    }
}
```





