package genshinbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService{
    @Value("${spring.mail.username}")
    private String from;
    @Autowired
    private JavaMailSender mailSender;
    public void sendSimpleMail(String to, String idCode) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);//收信人
        message.setSubject("验证码");//主题
        message.setText("您的GenshinBook的验证码为："+idCode+"\n"+"请在5分钟内完成验证");//内容
        message.setFrom(from);//发信人
        mailSender.send(message);
    }
}