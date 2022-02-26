package genshinbook.dao;

import genshinbook.bean.Music;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MusicDao {
    public List<Music> queryAllMusic();
}
