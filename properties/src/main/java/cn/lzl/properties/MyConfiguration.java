package cn.lzl.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 读取默认配置文件内的值
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "my")
public class MyConfiguration {
    private String name;
    private String describe;

}
