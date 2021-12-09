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
import java.util.List;
@Controller
public class OverViewController {
    @RequestMapping(value = "/",method = {RequestMethod.POST,RequestMethod.GET})
    public String find(HttpServletRequest request){
        System.out.println( request.getRemoteAddr());
        String re = request.getParameter("request");
        return "redirect:"+re;
    }

    @ResponseBody
    @RequestMapping(value = "/getOverviewImageUri", method = {RequestMethod.GET, RequestMethod.POST})
    public List<OverView> OverView(HttpServletRequest request, RequestEntity<String> requestEntity){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/Spring.xml");
        OverViewService overViewService = applicationContext.getBean("overViewServiceImpl", OverViewService.class);
        return overViewService.queryAll();
    }

}
