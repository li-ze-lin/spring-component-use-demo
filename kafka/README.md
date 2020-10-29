# springframework kafka 使用演示

## 基于springboot的基础上引入
```xml
<dependency>
    <groupId>org.springframework.kafka</groupId>
    <artifactId>spring-kafka</artifactId>
</dependency>
```

## 使用
```java
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
```

## 日志
```log
2020-10-14 14:32:49.204  INFO 17060 --- [ntainer#0-0-C-1] cn.lzl.kafka.KafkaDemoApplication        : ConsumerRecord(topic = DEMO_TOPIC, partition = 0, leaderEpoch = 0, offset = 2, CreateTime = 1602657169131, serialized key size = -1, serialized value size = 129, headers = RecordHeaders(headers = [], isReadOnly = false), key = null, value = Message(id=f004db49-6b29-4932-928f-bc79da046897, msg=0fa63c56-fe60-4bcc-818f-4627c7507885, sendTime=Wed Oct 14 14:32:48 CST 2020))
2020-10-14 14:32:49.204  INFO 17060 --- [ntainer#0-0-C-1] cn.lzl.kafka.KafkaDemoApplication        : Message(id=f004db49-6b29-4932-928f-bc79da046897, msg=0fa63c56-fe60-4bcc-818f-4627c7507885, sendTime=Wed Oct 14 14:32:48 CST 2020)
```

## 附加
本来是打算zk和kafka都在docker运行 但是kafka没有官方的镜像 只有三方的 就放弃了 害怕有其他的坑 就在本地启动 用于记录启动流程
```java
/**
 * 1.下载zk
 * 2.配置zk 内zookeeper-3.4.13\conf文件下的zoo.cfg(默认有zoo_sample.cfg改成zoo.cfg即可在进行配置)
 * 3.下载kafka
 * 4.配置kafka_2.12-2.0.0\config的server.properties(zookeeper.connect=localhost:2181 配置成zk所在的地址)
 * 5.在kafka_2.12-2.0.0内命令行启动 .\bin\windows\kafka-server-start.bat .\config\server.properties
 */
```




