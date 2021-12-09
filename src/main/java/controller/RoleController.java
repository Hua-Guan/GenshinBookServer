package controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.RoleName;
import service.serviceImpl.RoleNameServiceImpl;
import java.util.List;

@Controller
@ResponseBody
public class RoleController {
    @RequestMapping(value = "/getAllRoleImageUri",method = {RequestMethod.POST,RequestMethod.GET})
    public List<RoleName> getAllRoleImageUri(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/Spring.xml");
        RoleNameServiceImpl roleNameService = applicationContext.getBean("roleNameServiceImpl", RoleNameServiceImpl.class);
        return roleNameService.queryAll();
    }

}
