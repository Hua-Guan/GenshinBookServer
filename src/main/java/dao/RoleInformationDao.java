package dao;

import pojo.RoleInformation;

public interface RoleInformationDao {
    public RoleInformation queryRoleByName(String name);
}
