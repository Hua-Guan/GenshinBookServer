package dao.daoImpl;

import dao.OverViewDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pojo.OverView;

import java.util.List;
@Repository
public class OverViewDaoImpl implements OverViewDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<OverView> queryAll() {
        String sql = "select * from overview";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<OverView>(OverView.class));
    }
}
