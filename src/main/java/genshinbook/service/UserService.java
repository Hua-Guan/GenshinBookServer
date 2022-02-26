package genshinbook.service;

import genshinbook.bean.User;
import genshinbook.dao.UserDao;
import genshinbook.mythrow.GenshinThrow;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private MailService mailService;
    public User login(User user){
        String password = userDao.getPassword(user.getE_mail());
        if (password == null){
            return null; //代表当前e_mail并没有注册
        }
        Boolean checkPw  = BCrypt.checkpw(user.getPassword(), password);//解密
        if (checkPw){
            user.setPassword(password);
            return userDao.login(user);//代表正确
        }
        else {
            return user;//代表密码错误
        }
    }
    @Transactional
    public Integer register(User user){
        String hashPw = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt() );//加密
        user.setPassword(hashPw);
        Integer id = userDao.register(user);
        if (id == null){
            throw  new GenshinThrow("205","注册失败") ;
        }else {
            return user.getId();
        }
    }

    //处理忘记密码
    @Transactional
    public Integer updatePassword(User user){
        if (StringUtils.isEmpty(user.getPassword())){
            throw new GenshinThrow("201","密码不能为空");
        }
        if (userDao.getPassword(user.getE_mail())==null){
            throw new GenshinThrow("202","账号还未注册");
        }

        String hashPw = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt() );//加密
        user.setPassword(hashPw);
        Integer integer = userDao.updatePassword(user);
        if (integer == null){
            throw new GenshinThrow("112","密码修改失败");
        }else {
            return user.getId();
        }
    }
}
