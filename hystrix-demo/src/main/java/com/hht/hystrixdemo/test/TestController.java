package com.hht.hystrixdemo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <br/>Author hanhaotian
 * <br/>Description :
 * <br/>CreateTime 2018-12-14
 */
@RestController
public class TestController {
    @Autowired
    private UserClient userClient;

    @RequestMapping("/getPortInfo")
    public String getPort() {
        return userClient.getPort();
    }

}
