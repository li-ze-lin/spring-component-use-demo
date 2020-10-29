package cn.lzl.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

@Service
public class HystrixService {

    @HystrixCommand(fallbackMethod = "failFallbackMethod")
    public String fail() {
        throw new RuntimeException();
    }

    public String failFallbackMethod() {
        return "failFallbackMethod";
    }
}
