package genshinbook.bean;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("音乐影集")
@Data
public class MusicAlbum {
    private String AlbumName;

    private String AlbumAuthor;

    private String AlbumCover;

}
