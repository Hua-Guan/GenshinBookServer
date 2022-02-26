package genshinbook.mythrow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenshinThrow extends RuntimeException{
    //状态码
    private String code;
    //错误信息
    private String Msg;
}
