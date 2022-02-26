package genshinbook.dao;

import genshinbook.bean.OverView;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OverViewDao {
    public List<OverView> queryAll();
}
