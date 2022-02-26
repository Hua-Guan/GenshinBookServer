package genshinbook.controller;

import genshinbook.bean.OverView;
import genshinbook.dao.OverViewDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class OverViewController {
    @Autowired
    private OverViewDao overViewDao;
    @RequestMapping(value = "/",method = {RequestMethod.POST,RequestMethod.GET})
    public String find(HttpServletRequest request,HttpServletResponse response) throws IOException {
        System.out.println( request.getRemoteAddr());
        String re = request.getParameter("request");
        if (re == null){
            response.getWriter().print("路径输入有误");
            return "";
        }
        return "forward:/"+re;
    }

    @ResponseBody
    @RequestMapping(value = "getOverviewImageUri", method = {RequestMethod.GET, RequestMethod.POST})
    public List<OverView> OverView(HttpServletResponse response){
//         设置缓存时间为1分钟 时间单位为秒
        response.addHeader("Cache-Control", "max-age=60");
        return overViewDao.queryAll();
    }
}
