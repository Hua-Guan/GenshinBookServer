package genshinbook.controller;

import genshinbook.bean.RoleInformation;
import genshinbook.dao.RoleInformationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;

@RestController
public class RoleInformationController {
    @Autowired
    private RoleInformationDao roleInformationDao;
    @RequestMapping(value = "getRoleInformationAndImageUri",method = {RequestMethod.POST,RequestMethod.GET})
    public RoleInformation getRoleInformationAndImageUri(@RequestParam("roleName") String roleName, HttpServletResponse response){
        response.addHeader("Cache-Control", "max-age=60");
        return roleInformationDao.queryRoleByName(roleName);
    }
}
