package Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.serviceImpl.RoleNameServiceImpl;

public class Test {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/Spring.xml");
        RoleNameServiceImpl overViewService = applicationContext.getBean("roleNameServiceImpl", RoleNameServiceImpl.class);
        System.out.println(overViewService.queryAll());
    }
}
