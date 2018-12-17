package com.hht.hystrixdemo.test;

import org.springframework.stereotype.Service;

/**
 * <br/>Author hanhaotian
 * <br/>Description : 熔断类
 * <br/>CreateTime 2018-12-14
 */
@Service
public class UserClientHystrix implements UserClient{

    @Override
    public String getPort() {
        return "getPost()服务不可用...";
    }
}
