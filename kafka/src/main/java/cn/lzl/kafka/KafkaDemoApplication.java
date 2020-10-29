package cn.lzl.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

import javax.annotation.Resource;

import static cn.lzl.kafka.Message.generate;

@Slf4j
@SpringBootApplication
public class KafkaDemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(KafkaDemoApplication.class, args);
    }

    //订阅的topic
    private static final String TOPIC = "DEMO_TOPIC";

    //spring官方提供
    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void run(String... args) throws Exception {
        Message generate = generate();
        //生产者
        kafkaTemplate.send(TOPIC, generate.toString());
    }

    //订阅(消费者)
    @KafkaListener(topics = TOPIC)
    public void listen(ConsumerRecord<?, ?> cr) throws Exception {
        log.info(cr.toString());
        log.info(cr.value().toString());
    }
}
