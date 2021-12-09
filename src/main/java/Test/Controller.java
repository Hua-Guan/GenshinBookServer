//package Test;
//
//import com.fasterxml.jackson.databind.util.JSONPObject;
//import org.springframework.http.RequestEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import javax.servlet.http.HttpServletRequest;
//import java.util.HashMap;
//
//@org.springframework.stereotype.Controller
//public class Controller {
//    @RequestMapping(value = "/" , method = {RequestMethod.GET, RequestMethod.POST})
//    @ResponseBody
//    public HashMap test(HttpServletRequest request, RequestEntity<String> requestEntity){
//        System.out.println( request.getRemoteAddr());
//        System.out.println(requestEntity);
//        String test = request.getParameter("test");
//        System.out.println(test);
//        HashMap map = new HashMap();
//        map.put("imageUri","1356");
//        map.put("typeName","386547");
//        return map;
//    }
//
//
//}
