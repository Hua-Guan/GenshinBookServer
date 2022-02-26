package genshinbook;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("genshinbook.dao")
public class GenshinBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenshinBookApplication.class, args);
    }

}
