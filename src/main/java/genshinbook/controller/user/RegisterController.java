package genshinbook.controller.user;

import genshinbook.bean.User;
import genshinbook.dao.UserDao;
import genshinbook.mythrow.GenshinThrow;
import genshinbook.service.MailService;
import genshinbook.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.ServletContext;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
public class RegisterController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private MailService mailService;
    @Autowired
    private UserService userService;
    @Autowired
    private ServletContext servletContext;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @GetMapping("/getIdCode")
    public String getIdCode(@RequestParam("e_mail") String e_mail){
        String password = userDao.getPassword(e_mail);
        if (password != null){
            return "该账号已经被注册";
        }
        else {
            Random random = new Random();
            String idCode="";
            for (int i=0;i<6;i++)
            {
                idCode+=random.nextInt(10);
            }
            String finalIdCode = idCode;
            servletContext.setAttribute(e_mail,idCode);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    mailService.sendSimpleMail(e_mail, finalIdCode);
                    //设置有效时间
                    redisTemplate.opsForValue().set("Email"+e_mail,finalIdCode,5, TimeUnit.MINUTES);
                }
            }).start();
//            new Thread(new Runnable() {
//                @SneakyThrows
//                @Override
//                public void run() {
//                    Thread.sleep(1000*60*5);
//                    servletContext.removeAttribute(e_mail);
//                }
//            }).start();

            return "验证码发送成功";
        }
    }
    @PostMapping("/register")
    public Integer register(@RequestParam("idCode") String idCode, User user) {
        String e_mail = user.getE_mail();
        System.out.println(user);
        String idCodeSend = redisTemplate.opsForValue().get("Email"+e_mail);
        System.out.println(idCodeSend);
        if (idCode!=null && idCode.equals(idCodeSend)){
            Integer register = userService.register(user);
            if (register != null){
                redisTemplate.delete("Email"+e_mail);
                return register;
            }else {
                throw  new GenshinThrow("205","注册失败");
            }
        }
        throw new GenshinThrow("206","验证码错误");
    }

    //修改密码
    @PostMapping("/password")
    public String updatePassword(@RequestParam("idCode") String idCode, User user) {
        String e_mail = user.getE_mail();
        String idCodeSend = redisTemplate.opsForValue().get("Email"+e_mail);
        System.out.println(idCodeSend);
        if (idCode!=null && idCode.equals(idCodeSend)){
            Integer updatePassword = userService.updatePassword(user);
            if (updatePassword == null){
                redisTemplate.delete("Email"+e_mail);
                return "密码修改成功，重新登入";
            }else {
                throw new GenshinThrow("112","密码修改失败");
            }
        }
        throw new GenshinThrow("1127","验证码有误");
    }
    @GetMapping("/Code")
    public String getCode(@RequestParam("e_mail") String e_mail){


            Random random = new Random();
            String idCode="";
            for (int i=0;i<6;i++)
            {
                idCode+=random.nextInt(10);
            }
            String finalIdCode = idCode;
            servletContext.setAttribute(e_mail,idCode);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    mailService.sendSimpleMail(e_mail, finalIdCode);
                    //设置有效时间
                    redisTemplate.opsForValue().set("Email"+e_mail,finalIdCode,5, TimeUnit.MINUTES);
                }
            }).start();
//            new Thread(new Runnable() {
//                @SneakyThrows
//                @Override
//                public void run() {
//                    Thread.sleep(1000*60*5);
//                    servletContext.removeAttribute(e_mail);
//                }
//            }).start();

            return "验证码发送成功";
        }
    }
