package com.hht.feigndemo.test;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <br/>Author hanhaotian
 * <br/>Description : 调用的远程服务接口
 * <br/>CreateTime 2018-12-14
 */
@FeignClient(value = "eureka-client-one")
//@FeignClient(value = "EUREKA-RIBBON")
public interface UserClient {

    @RequestMapping("/port")
    String getPort();

}
