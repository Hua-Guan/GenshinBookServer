package genshinbook.controller;

import genshinbook.bean.RoleName;
import genshinbook.dao.RoleNameDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class RoleNameController {
    @Autowired
    private RoleNameDao roleNameDao;
    @RequestMapping(value = "getAllRoleImageUri",method = {RequestMethod.POST,RequestMethod.GET})
    public List<RoleName> getAllRoleImageUri(HttpServletResponse response){
        response.addHeader("Cache-Control", "max-age=60");
        return roleNameDao.queryAll();
    }
}
