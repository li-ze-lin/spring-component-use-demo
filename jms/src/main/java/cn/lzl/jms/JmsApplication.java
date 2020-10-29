package cn.lzl.jms;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;

import javax.annotation.Resource;

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
