package org.gec.service;

import org.gec.pojo.Users;

/**
 * @Description 用户类Service
 * @Author 余永浩
 * @Date 21:17 2020/6/20
**/
public interface UserService {

    //  1.登陆
    Users login(String username, String password);
}
