package service.serviceImpl;

import dao.RoleInformationDao;
import dao.RoleNameDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.RoleInformation;
import pojo.RoleName;
import service.RoleInformationService;
@Service
public class RoleInformationServiceImpl implements RoleInformationService {
    @Autowired
    private RoleInformationDao roleInformationDao;
    @Autowired
    private RoleNameDao roleNameDao;
    @Override
    public RoleInformation queryRoleByName(String name) {
        RoleInformation roleInformation = roleInformationDao.queryRoleByName(name);
        RoleName roleName = roleNameDao.queryUriByName(name);
        roleInformation.setRoleUri(roleName.getRoleUri());
        return roleInformation;
    }
}
