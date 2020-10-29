package cn.lzl.consul.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("service")
public interface Service {

    @GetMapping
    String get();
}
