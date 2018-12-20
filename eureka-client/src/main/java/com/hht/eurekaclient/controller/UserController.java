package com.hht.eurekaclient.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hht.eurekaclient.bean.UserEntity;
import com.hht.eurekaclient.service.IUserService;
import com.hht.eurekaclient.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 控制层
 * @author LinkinStar
 */
@Controller
public class UserController {

    /** 用户服务 **/
    @Autowired
    private IUserService userService;

    /** 用户服务 **/
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/test")
    public String test(HttpServletRequest request, Model model, @RequestParam(required = false) Integer pageNum){
        //分页参数校验
        int pageSize = 3;
        if (pageNum == null || pageNum < 1) {
            pageNum = 1;
        }

        //进行分页查询
        PageHelper.startPage(pageNum, pageSize);
        List<UserEntity> userList = userService.listUser();
        PageInfo pageInfo = new PageInfo(userList);

        //设置返回参数
        request.setAttribute("userList", userList);
        model.addAttribute("userList", userList);
        request.setAttribute("pageNum", pageNum);
        request.setAttribute("pageSum", pageInfo.getPages());

        //测试session存放redis
        HttpSession session = request.getSession();
        System.out.println("session数据：" + session.getAttribute("xxx"));
        session.setAttribute("xxx","123");
        System.out.println("session数据：" + session.getAttribute("xxx"));


        //测试redis
        UserEntity user = new UserEntity();
        user.setId(1001);
        user.setVal("xxx");

        redisUtil.set("xxx", user);
        Object object = redisUtil.get("xxx");
        UserEntity userTemp = (UserEntity) object;

        System.out.println("redis数据获取为: " + userTemp);
        redisUtil.delete("xxx");
        System.out.println("redis删除数据之后获取为: " + redisUtil.get("xxx"));

        //测试事务回滚
        //userService.addUser();

        return "index";
    }
}
