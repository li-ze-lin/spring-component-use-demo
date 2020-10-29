package cn.lzl.http2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Http2Controller {

    @GetMapping
    public String demo() {
        return "demo";
    }
}
