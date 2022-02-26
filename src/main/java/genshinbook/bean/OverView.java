package genshinbook.bean;

import lombok.Data;
import lombok.ToString;

/**
 * 这是主页
 * styleName 类型名
 * imageUri  图书路径
 */
@Data
@ToString
public class OverView {
    private String styleName;
    private String imageUri;
}
