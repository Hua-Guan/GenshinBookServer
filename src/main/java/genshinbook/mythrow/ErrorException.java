package genshinbook.mythrow;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class ErrorException {
    //全局异常配置
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String error(Exception e){
        e.printStackTrace();
        return "出现全局异常"+e.getMessage();
    }
    //自定义异常
    @ExceptionHandler(GenshinThrow.class)
    @ResponseBody
    public String error(GenshinThrow e) {
        log.error(e.getMessage());
        e.printStackTrace();
        return e.getMsg();

    }

}