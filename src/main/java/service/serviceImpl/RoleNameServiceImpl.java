package service.serviceImpl;

import dao.RoleNameDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.RoleName;
import service.RoleNameService;

import java.util.List;
@Service
public class RoleNameServiceImpl implements RoleNameService {
    @Autowired
    private RoleNameDao roleNameDao;
    @Override
    public List<RoleName> queryAll() {
        return roleNameDao.queryAll();
    }
}
