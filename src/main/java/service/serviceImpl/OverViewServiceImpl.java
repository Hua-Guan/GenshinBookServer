package service.serviceImpl;

import dao.OverViewDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.OverView;
import service.OverViewService;

import java.util.List;
@Service
public class OverViewServiceImpl implements OverViewService {
    @Autowired
    private OverViewDao overViewDao;
    @Override
    public List<OverView> queryAll() {
        return overViewDao.queryAll();
    }
}
