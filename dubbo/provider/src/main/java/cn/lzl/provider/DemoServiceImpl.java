package cn.lzl.provider;


import cn.lzl.client.DemoService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class DemoServiceImpl implements DemoService {

    @Override
    public String print(String data) {
        System.out.println(data);
        return "provider : " + data;
    }

}
