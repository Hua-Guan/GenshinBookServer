package Test;

import dao.RoleInformationDao;
import dao.daoImpl.RoleInformationDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.RoleInformationService;
import service.serviceImpl.RoleInformationServiceImpl;
import service.serviceImpl.RoleNameServiceImpl;

public class Test {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/Spring.xml");
//        RoleNameServiceImpl overViewService = applicationContext.getBean("roleNameServiceImpl", RoleNameServiceImpl.class);
//        System.out.println(overViewService.queryAll());
        RoleInformationServiceImpl roleInformationServiceImpl = applicationContext.getBean("roleInformationServiceImpl", RoleInformationServiceImpl.class);
        roleInformationServiceImpl.queryRoleByName("七七");
        System.out.println(roleInformationServiceImpl.queryRoleByName("七七"));
    }
}
