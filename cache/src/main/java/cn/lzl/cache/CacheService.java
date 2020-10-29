package cn.lzl.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

    private volatile String data = "";

    @Cacheable(value = "dataCache")
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @CacheEvict(value = "dataCache", allEntries = true, beforeInvocation = true)
    public void setClearData(String data) {
        this.data = data;
    }
}
