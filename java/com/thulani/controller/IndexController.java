package com.thulani.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping({"/", "/textbook.index"})
    String home(){
        return "Textbook_System Index Page";
    }

}
