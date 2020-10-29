# springframework amqp(rabbit) 使用演示

## 引入
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-amqp</artifactId>
</dependency>
```

## 使用
```java
@SpringBootApplication
public class AmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmqpApplication.class, args);
    }

    /**
     * 生产者
     */
    @Bean
    public ApplicationRunner runner(AmqpTemplate amqpTemplate) {
        return args -> amqpTemplate.convertAndSend("myqueue", "foo");
    }

    /**
     * 队列
     */
    @Bean
    public Queue myQueue() {
        return QueueBuilder.durable("myqueue").build();
    }

    /**
     * 消费者
     */
    @RabbitListener(queues = "myqueue")
    public void listen(String in) {
        System.out.println(in);
    }
}
```





