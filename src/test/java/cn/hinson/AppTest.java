package cn.hinson;

import static org.junit.Assert.assertTrue;

import cn.hinson.dao.UserDao;
import cn.hinson.domain.SysUser;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Autowired
    UserDao userDao;
    @Test
    public void shouldAnswerWithTrue()
    {
        SysUser user = userDao.findByUserName("admin");
        System.out.println(user == null);
    }
}
