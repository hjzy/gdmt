package com.train.gdmt.contract.controller;


import com.train.gdmt.contract.model.Contract;
import com.train.gdmt.contract.service.ContractService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("contract")
public class ContractControl {

    @Autowired
    private ContractService contractService;

    private static final Logger LOGGER = Logger.getLogger(ContractControl.class);

    @RequestMapping("toLogin")
    public String toLogin() {
        return "login-simple";
    }

    @RequestMapping("doLogin")
    public String doLogin(String username, String password, HttpSession session, HttpServletRequest request) {
        System.out.println(DigestUtils.md5Hex(password));
        Contract loginContract = contractService.login(username);
        System.out.println(DigestUtils.md5Hex(loginContract.getPwd()));


        if (DigestUtils.md5Hex(password).equals(DigestUtils.md5Hex(loginContract.getPwd()))) {
            session.setAttribute("loginUser", loginContract);
            switch (loginContract.getRole()) {
                // 1：监察人员 2：管理人员 3：系统管理员 4：公告发布员',
                case "1":

                    return "index";
                case "2":
                case "3":
                    LOGGER.info("管理员登录成功！");
                    return "index";
                case "4":
                    //  return "redirect:/announcement/findAllAnnouncement";
                    return "redirect:/announcement/page";
                case "5":

            }
        } else {
            request.setAttribute("loginError", "用户名和密码错误");
            return "login-simple";
        }
        // request.setAttribute("loginerror","用户名和密码错误");
        return "login";
    }
}
