package com.hht.eurekaclient.service;

import com.hht.eurekaclient.bean.UserEntity;

import java.util.List;

/**
 * 服务层接口
 * @author LinkinStar
 */
public interface IUserService {

    /**
     * 查询数据
     */
    List<UserEntity> listUser();

    /**
     * 添加数据
     */
    boolean addUser();
}
