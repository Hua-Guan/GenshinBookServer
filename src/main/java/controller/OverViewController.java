package controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.OverView;
import service.OverViewService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@Controller
public class OverViewController {
    @RequestMapping(value = "/",method = {RequestMethod.POST,RequestMethod.GET})
    public String find(HttpServletRequest request, RequestEntity<String> requestEntity,HttpServletResponse response){
        System.out.println( request.getRemoteAddr());
        System.out.println(requestEntity);
        String re = request.getParameter("request");
        if (re == null){
            return "index";
        }
        return "forward:/"+re;
    }

    @ResponseBody
    @RequestMapping(value = "/getOverviewImageUri", method = {RequestMethod.GET, RequestMethod.POST})
    public List<OverView> OverView(HttpServletRequest request, HttpServletResponse response){
//         设置缓存时间为1分钟 时间单位为秒
        response.addHeader("Cache-Control", "max-age=60");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/Spring.xml");
        OverViewService overViewService = applicationContext.getBean("overViewServiceImpl", OverViewService.class);
        return overViewService.queryAll();
    }

}
