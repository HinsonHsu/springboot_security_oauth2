package cn.hinson.controller;

import cn.hinson.dao.UserDao;
import cn.hinson.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    UserDao userDao;

    @GetMapping
    public String test(){
        SysUser sysUser = new SysUser();
        sysUser.setUsername("hinson1");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String tmp = passwordEncoder.encode("password");
        sysUser.setPassword(tmp);
        userDao.create(sysUser);
        return "success";
    }
}
