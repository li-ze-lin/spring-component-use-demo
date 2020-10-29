package cn.lzl.amqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
