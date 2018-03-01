package com.dylan.music.controller;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.dylan.music.dao.GetMusicData;
import com.dylan.music.services.GetMusicServices;
import com.dylan.music.services.TestServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dzkan on 2016/3/8.
 */
@Controller
public class MainController {


    @Autowired
    TestServices testServices;
    @Autowired
    GetMusicServices getMusicServices;

    @RequestMapping(value = "/test", method = {RequestMethod.GET,RequestMethod.POST})
    public String index() {
        testServices.testInsert();
        return "test";
    }
    @RequestMapping(value = "/testService", method = RequestMethod.GET)
    public String testService() {
        return "test";
    }
    @RequestMapping(value="/getMusic",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json; charset=utf-8")
    @ResponseBody
    public String hello(HttpServletResponse response) throws IOException {
        return JSON.toJSONString(getMusicServices.getGetMusicData());
    }
}