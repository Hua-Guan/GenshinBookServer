package genshinbook.controller;

import genshinbook.bean.Music;
import genshinbook.dao.MusicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MusicController {
    @Autowired
    private MusicDao musicDao;
    @GetMapping("musicBean")
    public List<Music> query(){
        return musicDao.queryAllMusic();
    }
}
