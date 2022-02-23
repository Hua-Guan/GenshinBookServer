package controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.RoleInformation;
import pojo.RoleName;
import service.serviceImpl.RoleInformationServiceImpl;
import service.serviceImpl.RoleNameServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class RoleController {
    @ResponseBody
    @RequestMapping(value = "/getAllRoleImageUri",method = {RequestMethod.POST,RequestMethod.GET})
    public List<RoleName> getAllRoleImageUri(HttpServletResponse response){
        response.addHeader("Cache-Control", "max-age=60");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/Spring.xml");
        RoleNameServiceImpl roleNameService = applicationContext.getBean("roleNameServiceImpl", RoleNameServiceImpl.class);
        return roleNameService.queryAll();
    }
    @ResponseBody
    @RequestMapping(value = "/getRoleInformationAndImageUri",method = {RequestMethod.POST,RequestMethod.GET})
    public RoleInformation getRoleInformationAndImageUri(HttpServletRequest request,HttpServletResponse response){
        response.addHeader("Cache-Control", "max-age=60");
        System.out.println(request.getParameter("roleName"));
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/Spring.xml");
        RoleInformationServiceImpl roleInformationServiceImpl = applicationContext.getBean("roleInformationServiceImpl", RoleInformationServiceImpl.class);
        RoleInformation roleInformation = roleInformationServiceImpl.queryRoleByName(request.getParameter("roleName"));
        return roleInformation;
    }
}
