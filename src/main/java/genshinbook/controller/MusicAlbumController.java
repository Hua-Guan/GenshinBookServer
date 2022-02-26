package genshinbook.controller;

import genshinbook.bean.MusicAlbum;
import genshinbook.service.MusicAlbumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api("music")
public class MusicAlbumController {
    @Autowired
    private MusicAlbumService musicAlbumService;
    @ApiOperation("查询所有的音乐信息")
    @PostMapping("music")
    public List<MusicAlbum> findMusicAlbum(){
        return musicAlbumService.musicList();
    }
}
