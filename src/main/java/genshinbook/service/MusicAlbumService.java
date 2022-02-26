package genshinbook.service;

import genshinbook.bean.MusicAlbum;
import genshinbook.dao.MusicAlbumDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicAlbumService {
    @Autowired
    private MusicAlbumDao musicAlbumDao;
    public List<MusicAlbum> musicList(){
        return musicAlbumDao.musicList();
    };
}
