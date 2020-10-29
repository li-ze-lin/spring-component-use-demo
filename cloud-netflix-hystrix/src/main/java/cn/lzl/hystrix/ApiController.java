package cn.lzl.hystrix;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping
public class ApiController {

    @Resource
    private HystrixService hystrixService;

    @GetMapping
    public String fail() {
        return hystrixService.fail();
    }
}
