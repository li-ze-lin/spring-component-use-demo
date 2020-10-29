# spring boot 整合 apache dubbo spring boot

## 基于springboot的基础上引入
```xml
<dependency>
    <groupId>org.apache.dubbo</groupId>
    <artifactId>dubbo-spring-boot-starter</artifactId>
    <version>2.7.8</version>
</dependency>
<dependency>
    <groupId>org.apache.curator</groupId>
    <artifactId>curator-framework</artifactId>
    <version>4.0.1</version>
</dependency>
<dependency>
    <groupId>org.apache.curator</groupId>
    <artifactId>curator-recipes</artifactId>
    <version>4.0.1</version>
</dependency>
```

## 服务提供方
```java
//code
public interface DemoService {
    String print(String data);
}

//实现定义好的接口 并加上@DubboService注解
@DubboService
public class DemoServiceImpl implements DemoService {
    @Override
    public String print(String data) {
        System.out.println(data);
        return "provider : " + data;
    }
}
```
```properties
#config
dubbo.registry.address=zookeeper://127.0.0.1:2181
dubbo.protocol.name=dubbo
dubbo.protocol.port=20880
#指定实现接口的包
dubbo.scan.base-packages=cn.lzl.provider
```

## 服务调用方
```java
//code
@DubboReference
private DemoService demoService;

void consumerTest() {
    String test = demoService.print("test");
    System.out.println(test); //provider : test
}
```
```properties
#config
dubbo.protocol.port=20800
dubbo.protocol.name=dubbo
dubbo.registry.address=zookeeper://127.0.0.1:2181
```

## 参考
- [schema 配置(官方文档)](http://dubbo.apache.org/zh-cn/docs/user/references/xml/introduction.html)
- [apache dubbo-spring-boot-project 项目](https://github.com/apache/dubbo-spring-boot-project)