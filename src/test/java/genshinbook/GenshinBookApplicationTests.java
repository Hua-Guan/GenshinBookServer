package genshinbook;

import genshinbook.dao.RoleInformationDao;
import genshinbook.dao.RoleNameDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GenshinBookApplicationTests {
    @Autowired
    RoleInformationDao roleInformationDao;
    @Test
    void contextLoads() {
        System.out.println(roleInformationDao.queryRoleByName("丽莎"));

    }


}
