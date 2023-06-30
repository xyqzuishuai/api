package com.neu.aqimanagementsystem.controller;

import com.neu.aqimanagementsystem.dao.UserDao;
import com.neu.aqimanagementsystem.entity.User;
import com.neu.aqimanagementsystem.sercice.PasswordEncryptionService;
import com.neu.aqimanagementsystem.sercice.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncryptionService passwordEncryptionService;


    //用户登陆
    @RequestMapping ("/userlogin")

//    public String userLogin(Model model,    String mobile,  String password, HttpSession session)
    public String  userLogin (Model model,@RequestBody User user,HttpSession session) {

        if((user.getMobile() == null || user.getMobile() == "") || (user.getPassword() == null || user.getPassword() == "")){
            model.addAttribute("msg", "账号密码为空,请重新输入");
           return("账号密码为空,请重新输入");
        }
        else{
            User user1 = userService.findUserbymobile(user.getMobile());
            if(user1!=null && passwordEncryptionService.checkPassword(user.getPassword(),user1.getPassword())){
//            User user1 = userService.findUser(user.getMobile(), user.getPassword());

                model.addAttribute("user", user);
                session.setAttribute("user", user);


                if (user1.getLimits() == 1) {
                    return "admin";
                } else if (user1.getLimits() == 0) {
                    return "putong";
                } else if (user1.getLimits() == 2) {
                    return "admin2";
                }
            }
            model.addAttribute("msg", "账号密码错误,请重新输入");
            return "userlogin1";
        }}








    //用户注册
    @RequestMapping("/userzhuce")
    public String zhuce(@RequestBody User user) {
        User user1 = userService.findUserid_card(user.getId_card());
        if (user1 == null) {
            if (user.getLimits() == null) {
                user.setLimits(0);
            }

            String encryptedPassword = passwordEncryptionService.encryptPassword(user.getPassword());
            user.setPassword(encryptedPassword);

            userService.insertUser(user);
            return "创建完成";
        }else {
            return "该用户已存在";
        }
    }

    










}








