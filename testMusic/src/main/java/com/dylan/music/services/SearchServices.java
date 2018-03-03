package com.dylan.music.services;

import com.dylan.music.dao.GetMusicData;
import com.dylan.music.entity.MusicBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @description: 搜索服务，包括歌手，歌名
 * @author: Mr.Mu
 * @create: 2018-03-02 10:52
 **/
public class SearchServices {

    @Autowired
    GetMusicData getMusicData;

    public List<MusicBean> SearchMusicByName() {
        return  getMusicData.getMusicData();
    }

}
