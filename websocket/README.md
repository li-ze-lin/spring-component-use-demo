# spring boot websocket 使用演示

## pom引入
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-websocket</artifactId>
</dependency>
```

## 后端
```java
/**
 * 配置WebSocket
 */
@Configuration
//开启STOMP协议
@EnableWebSocketMessageBroker
public class MyWebSocket implements WebSocketMessageBrokerConfigurer {

    @Override
    //注册STOMP协议节点 映射的url
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        //广播 指定使用SockJS协议
        stompEndpointRegistry
                .addEndpoint("/broadcast")
                .setAllowedOrigins("*")//跨域
                .withSockJS();//使用SockJS
    }

    @Override
    //配置消息代理
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
    }
}

@Controller
@MessageMapping("/socket")
public class WebSocketController {

    //路径映射 如同@RequestMapping
    @MessageMapping("/welconee")
    //当服务端有消息 会向订阅了@SendTo("/topic/get")的发送消息
    @SendTo("/topic/get")
    public WebSocketDTO say(WebSocketDTO wsr) throws Exception {
        System.out.println(wsr.getMessage());
        System.out.println(wsr.getStr());
        return wsr;
    }
}
```

## 前端
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>接收广播</title>
    <script src="sockjs.min.js"></script>
    <script src="stomp.min.js"></script>
    <script src="jquery.min.js"></script>
</head>
<body>
    <h4>接收的消息为:</h4>
    <div id = "message"></div>
</body>

<script type="text/javascript">
    var stompClient = null;

    /**
     * 初始化链接
     */
    $(function() {
        //在MyWebSocket.java内配置的url
        var socket = new SockJS('http://127.0.0.1:11111/broadcast');
        stompClient = Stomp.over(socket);
        //获取广播
        stompClient.connect({}, function(frame) {
            console.log(frame);
            //在WebSocketController.java内@SendTo的url
            stompClient.subscribe('/topic/get', function(respnose){
                console.log(respnose);
                var mag = JSON.parse(respnose.body);
                $('#message').text(mag.message + mag.str)
            });
        });
    });

</script>
</html>
```

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>发广播</title>
    <script src="sockjs.min.js"></script>
    <script src="stomp.min.js"></script>
    <script src="jquery.min.js"></script>
</head>
<body>
    <input type="text" id="out">
    <input type="button" onclick="out()" value="发广播">
    <div id = "outdiv"></div>
</body>

<script type="text/javascript">
    var stompClient = null;

    /**
     * 初始化链接
     */
    $(function() {
        //在MyWebSocket.java内配置的url
        var socket = new SockJS('http://127.0.0.1:11111/broadcast');
        stompClient = Stomp.over(socket);
    })

    /**
     * 发送消息
     */
    function out() {
        var mag = $('#out').val();
        //在WebSocketController.java内@MessageMapping的url
        stompClient.send("/socket/welconee", {}, JSON.stringify({ 'message': mag, 'str' : ':string' }));
    }

</script>
</html>
```



