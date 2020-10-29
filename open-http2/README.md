# springboot 开启http2

## http2 需要在 https的基础上开启 所以 这里需要先生成一份证书

```shell script
#Java自带了一个密钥管理工具--keytool，利用这个工具，我们可以产生一份自签名的证书
C:\project\github\spring-component-use-demo>keytool -genkey -alias undertow -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore keystore.p12 -dname "CN=li, OU=zelin, O=zelin, L=bj, ST=
bj, C=CN"
输入密钥库口令:
再次输入新口令:
# 这里的口令需要后面在项目内配置 将生成的keystore.p12 放在项目根目录下即可
```

## 项目配置
```properties
#端口号
server.port=443

#配置ssl (https)
#keystore.p12的路径
server.ssl.key-store=keystore.p12
#之前输入的口令
server.ssl.key-password=lizelin
server.ssl.key-store-password=lizelin
#配置ssl (https) end

#使用http2
server.http2.enabled=true
```

## controller
```java
@RestController
@RequestMapping
public class Http2Controller {

    @GetMapping
    public String demo() {
        return "demo";
    }
}
```

## 结果

```
https://127.0.0.1
```

| Name       | Status  |  Protocol  |
| ---        | ---     | ---        |
| 127.0.0.1  | 200     |   h2       | 

## http转https配置
```java
@Configuration
public class Http2HttpsConfig {

    @Bean
    public Connector connector(@Value("${server.port}") int port){
        Connector connector=new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setPort(80);
        connector.setSecure(false);
        connector.setRedirectPort(port);
        return connector;
    }

    @Bean
    public TomcatServletWebServerFactory tomcatServletWebServerFactory(Connector connector){
        TomcatServletWebServerFactory tomcat=new TomcatServletWebServerFactory(){
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint securityConstraint=new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection=new SecurityCollection();
                collection.addPattern("/*");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };
        tomcat.addAdditionalTomcatConnectors(connector);
        return tomcat;
    }
}
```