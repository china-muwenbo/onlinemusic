package com.dylan.onlinemusic;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dzkan on 2016/3/8.
 */
@Controller
public class MainController2 {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
    @RequestMapping(value = "/testService", method = RequestMethod.GET)
    public String testService() {

        return "index";
    }

}