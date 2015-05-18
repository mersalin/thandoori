package com.tastydine.controller;

import com.tastydine.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Software on 5/13/2015.
 */
@RestController
public class Controller {

    @Autowired
    private Service service;

    @RequestMapping("/welcome")
    public @ResponseBody String welcome() {
        return service.welcome();
    }
}
