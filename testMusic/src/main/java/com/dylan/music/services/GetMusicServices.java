package com.dylan.music.services;

import com.dylan.music.dao.GetMusicData;
import com.dylan.music.entity.MusicBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetMusicServices {
   @Autowired
    GetMusicData getMusicData;

    public List<MusicBean> getGetMusicData() {

        return  getMusicData.getMusicData();

    }
}
