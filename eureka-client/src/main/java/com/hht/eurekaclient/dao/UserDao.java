package com.hht.eurekaclient.dao;

import com.hht.eurekaclient.bean.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 数据访问层
 * @author LinkinStar
 */
@Repository
public interface UserDao {

    /**
     * 查询数据
     * @return 用户列表
     */
    List<UserEntity> listUser();

    /**
     * 添加数据
     */
    boolean addUser();
}
