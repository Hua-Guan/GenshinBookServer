package genshinbook;

import genshinbook.bean.User;
import genshinbook.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class UserDaoTest {
    @Autowired
    UserDao userDao;
    @Test
    public void login(){
        User login = userDao.login(new User(null, "username", "password"));
        System.out.println(login);
    }
    @Test
    public void register(){
        String hashPw = BCrypt.hashpw("password", BCrypt.gensalt() );//加密
        Integer id = userDao.register(new User(null, "383215@qq.com",hashPw));
        System.out.println(id);
    }
}
