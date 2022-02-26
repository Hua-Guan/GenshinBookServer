package genshinbook.dao;

import genshinbook.bean.MusicAlbum;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicAlbumDao {
    public List<MusicAlbum> musicList();
}
