package genshinbook.controller.user;

import genshinbook.bean.User;
import genshinbook.mythrow.GenshinThrow;
import genshinbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class LoginController {
    @Autowired
    UserService userService;
    @PostMapping("/login")
    public Integer Login(User user){
        User loginUser = userService.login(user);
        if (loginUser == null) {
            throw new GenshinThrow("235","当前邮箱还没有注册");
        }
        if (loginUser == user){
            throw new GenshinThrow("222","密码输入有误");
        }
        else {
            return loginUser.getId();
        }
    }
}
