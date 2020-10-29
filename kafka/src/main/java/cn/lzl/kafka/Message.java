package cn.lzl.kafka;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class Message {

    private String id;

    private String msg;

    private Date sendTime;

    public static Message generate() {
        Message message = new Message();
        message.setId(UUID.randomUUID().toString());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());
        return message;
    }
}
