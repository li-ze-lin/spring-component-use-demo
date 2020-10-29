package cn.lzl.cache;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

class CacheServiceTest extends CacheApplicationTests {

    @Resource
    private CacheService cacheService;

    @Test
    public void cacheTest() {
        cacheService.setData("1");
        String data = cacheService.getData();
        System.out.println(data);
        System.out.println();
        Assertions.assertEquals("1", data);

        cacheService.setData("2");
        data = cacheService.getData();
        System.out.println(data);
        System.out.println();
        Assertions.assertEquals("1", data);

        cacheService.setClearData("2");
        data = cacheService.getData();
        System.out.println(data);
        System.out.println();
        Assertions.assertEquals("2", data);
    }
}