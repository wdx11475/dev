package com.wdx.controller;

import com.wdx.model.User;
import com.wdx.servcie.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("add")
    public String add(){
        return "user/add";
    }

    @RequestMapping("update")
    public String update(){
        return "user/update";
    }

    @RequestMapping("toLogin")
    public String toLogin(){
        return"login";
    }

    @RequestMapping("unAuthor")
    public String unAuthor(){
        return "unAuthor";
    }

    @RequestMapping("toSave")
    public String toSave(){
        return "user/add";
    }

    /**
     * 登录逻辑处理
     * @return
     */
    @RequestMapping("login")
    public String login(String name, String password, Model model){
        /**
         * 使用shiro编写认证操作
         */
        //1.获取Subject
        Subject subject=SecurityUtils.getSubject();

        //2.封装用户数据
        UsernamePasswordToken token=new UsernamePasswordToken(name,password);

        //3.执行登录方法
        try {
            subject.login(token);

            //登录成功
            //跳转到test.html
            return "redirect:/testThymeleaf";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户不存在");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "login";
        }

    }

    @RequestMapping("saveUser")
    public void saveUser(User user){
        // 获取盐值，即用户名
        ByteSource salt = ByteSource.Util.bytes(user.getName());
        /*
         * MD5加密：
         * 使用SimpleHash类对原始密码进行加密。
         * 第一个参数代表使用MD5方式加密
         * 第二个参数为原始密码
         * 第三个参数为盐值，即用户名
         * 第四个参数为加密次数
         * 最后用toHex()方法将加密后的密码转成String
         * */
        String newPs = new SimpleHash("MD5", user.getPassword(), salt, 1).toHex();
        user.setPassword(newPs);
        userService.save(user);
    }
}
