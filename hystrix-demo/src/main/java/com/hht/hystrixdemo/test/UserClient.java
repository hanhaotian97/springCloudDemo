package com.hht.hystrixdemo.test;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <br/>Author hanhaotian
 * <br/>Description :
 * <br/>CreateTime 2018-12-14
 */
@FeignClient(value = "eureka-client-one",fallback = UserClientHystrix.class)
public interface UserClient {

    @RequestMapping("/port")
    String getPort();

}
