package genshinbook.dao;

import genshinbook.bean.RoleInformation;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleInformationDao {
    public RoleInformation queryRoleByName(String name);
}
