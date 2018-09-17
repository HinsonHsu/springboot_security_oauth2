package cn.hinson.dao;

import cn.hinson.domain.SysUser;


public interface UserDao {
    SysUser findByUserName(String username);
}