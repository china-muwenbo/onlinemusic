package com.dylan.music.services;

import com.dylan.music.dao.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServices {

    @Autowired
    private  Test test;

    public void testInsert(){
        test.insertMusic();
    }
}
