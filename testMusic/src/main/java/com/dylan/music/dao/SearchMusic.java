package com.dylan.music.dao;

import com.dylan.music.entity.MusicBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description: dao层 搜索服务
 * @author: Mr.Mu
 * @create: 2018-03-02 10:56
 **/
public interface SearchMusic {
    //搜索根据名字
    List<MusicBean> searchByName(@Param(value = "name") String name);
    //搜索根据歌曲名
    List<MusicBean> searchBySong(@Param(value = "name") String name);
//    List<MusicBean> searchBySong(String name);
    //搜索
//    List<MusicBean> search(String name);

}

