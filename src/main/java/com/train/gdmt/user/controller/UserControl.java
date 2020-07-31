package com.train.gdmt.user.controller;


import com.train.gdmt.user.model.User;
import com.train.gdmt.user.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("user")
public class UserControl {

    @Autowired
    private UserService userService;

    private static final Logger LOGGER = Logger.getLogger(UserControl.class);

    @RequestMapping("toLogin")
    public String toLogin() {
        return "login-simple";
    }

    @RequestMapping("doLogin")
    public String doLogin(String username, String password, HttpSession session, HttpServletRequest request){
        System.out.println(DigestUtils.md5Hex(password));
        User loginUser=userService.login(username);
        System.out.println(DigestUtils.md5Hex(loginUser.getPwd()));


        if(loginUser == null){
//demo
            return "login";
        }else{
            if(DigestUtils.md5Hex(password).equals(DigestUtils.md5Hex(loginUser.getPwd())))
            {
                session.setAttribute("loginUser",loginUser);
                switch (loginUser.getRole().toString()){
                    //1：燃料业务员 2：监察人员 3：管理人员 4：系统管理员 5：公告发布员',
                    case "1":

                        return "index";
                    case "2":
                    case "3":
                        return "index";
                    case "4":
                        LOGGER.info("管理员登录成功！");
                        return "admin/admin-index";
                    case "5":
                        return "index";


                }
            }
            else {
                request.setAttribute("loginerror","用户名和密码错误");
                return "login-simple";
            }
           // request.setAttribute("loginerror","用户名和密码错误");
        }
        return "login";
    }
}
