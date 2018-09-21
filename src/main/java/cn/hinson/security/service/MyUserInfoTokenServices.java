package cn.hinson.security.service;

import cn.hinson.dao.UserDao;
import cn.hinson.domain.SysUser;
import java.util.Map;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MyUserInfoTokenServices extends UserInfoTokenServices {


    private UserDao userDao;

    private String oauth2Type;
    public MyUserInfoTokenServices(String oauth2Type, String userInfoEndPointUrl, String clienId, UserDao userDao) {
        super(userInfoEndPointUrl, clienId);
        this.oauth2Type = oauth2Type;
        this.userDao = userDao;
    }

    @Override
    protected Object getPrincipal(Map<String, Object> map) {
        switch (oauth2Type) {
            case "facebook":
                System.out.println(map);
                break;
            case "github":
                System.out.println(map);
                SysUser sysUser = userDao.findByTwitter(map.get("id").toString());
                if(sysUser == null){
                    sysUser = new SysUser();
                    sysUser.setUsername(map.get("login").toString());
                    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                    String tmp = passwordEncoder.encode("password");
                    sysUser.setPassword(tmp);
                    sysUser.setTwitterId(map.get("id").toString());
                    userDao.create(sysUser);
                }
//                List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//                for(SysRole role:sysUser.getRoles())
//                {
//                    authorities.add(new SimpleGrantedAuthority(role.getName()));
//                    System.out.println(role.getName());
//                }
//                return sysUser;
                break;
            case "twitter":
                System.out.println(map);
                break;
        }

        return super.getPrincipal(map);
    }
}
