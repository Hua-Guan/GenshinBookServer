package dao.daoImpl;
import dao.RoleNameDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pojo.RoleName;
import java.util.List;
@Repository
public class RoleNameDaoImpl implements RoleNameDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<RoleName> queryAll() {
        String sql = "select * from role";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<RoleName>(RoleName.class));
    }
}
