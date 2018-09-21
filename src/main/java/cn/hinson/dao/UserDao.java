package cn.hinson.dao;

import cn.hinson.domain.SysRole;
import cn.hinson.domain.SysUser;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import java.util.List;

@EnableGlobalMethodSecurity(securedEnabled = true)
public interface UserDao {
    SysUser findByUserName(String username);
    SysUser findByFacebook(String facebookId);
    SysUser findByTwitter(String twitterId);
    void create(SysUser sysUseruser);
    void create();
//    List<SysRole> findSysRolesByUserName(String username);
}