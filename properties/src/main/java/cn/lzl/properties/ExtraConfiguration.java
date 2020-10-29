package cn.lzl.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 读取默认配置文件之外的文件
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "my.extra")
@PropertySource(value = "classpath:extra.properties")
public class ExtraConfiguration {
    private String name;
    private String describe;
}
