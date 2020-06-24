package org.gec.service.impl;

import org.gec.mapper.UsersMapper;
import org.gec.pojo.Users;
import org.gec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    //  引入资源
    @Autowired
    UsersMapper  usersMapper;

    //  1.用户登陆
    @Override
    public Users login(String username, String password) {

        //  1.登陆
        System.out.println("service__username:"+username);
        System.out.println("service__password:"+password);
        Users user =usersMapper.login(username,password);
        System.out.println("userService_user:"+user);
        return user;
    }
}
