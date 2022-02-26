package genshinbook.dao;

import genshinbook.bean.RoleName;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RoleNameDao {
    public List<RoleName> queryAll();
    public String queryUriByName(String name);

}
