package cn.lzl.consul.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/service")
    public String get() {
        return "service";
    }


}
