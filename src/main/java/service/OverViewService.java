package service;

import org.springframework.stereotype.Service;
import pojo.OverView;

import java.util.List;


public interface OverViewService {
     public List<OverView> queryAll();
}
