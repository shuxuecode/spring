package com.zsx.web.service.Impl;

import com.zsx.web.config.MyAnno;
import com.zsx.web.service.DemoService;
import com.zsx.web.util.CacheUtil;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by highness on 2018/1/25 0025.
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    @MyAnno(CacheUtil.CacheEnum.user)
    public String getDemo() {
        return UUID.randomUUID().toString();
    }
}
