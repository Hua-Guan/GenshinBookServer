package dao.daoImpl;

import dao.RoleInformationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pojo.RoleInformation;

import java.util.List;

@Repository
public class RoleInformationDaoImpl implements RoleInformationDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public RoleInformation queryRoleByName(String name) {
        String sql = "select * from roleinformation where RoleName = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<RoleInformation>(RoleInformation.class), name);
    }
}
