package org.gec.controller;

import org.gec.pojo.Users;
import org.gec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


/**
 * @Description 用户类controller
 * @Author 余永浩
 * @Date 21:08 2020/6/20
**/
@Controller
public class UserController {

    //  引入service层资源
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session){
        System.out.println("用户名："+username);
        System.out.println("密码："+password);
        //  1.登陆
        Users user= userService.login(username,password);
        System.out.println("user:"+user);
        //  2.判断
        if(user!=null){
           //   3.设置session
            session.setAttribute("user_session","user");
            //  4.返回跳转的页面
            return "forward:findFilmTypeList";
        }else{
            return "index";
        }
    }
}
