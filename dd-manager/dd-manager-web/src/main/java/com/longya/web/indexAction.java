package com.longya.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: Administrator
 * Date: 2017/11/14
 * Time: 15:43
 * Version:V1.0
 */
@Controller
@Scope("prototype")
public class indexAction {

    @RequestMapping("/")
    public String getIndex(){
        return "index";
    }
}
