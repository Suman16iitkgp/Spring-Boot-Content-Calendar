package com.Suman16iitkgp.contentCalendar.controller;

import com.Suman16iitkgp.contentCalendar.config.ContentCalenderProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final ContentCalenderProperties contentCalenderProperties;


    public HomeController(ContentCalenderProperties contentCalenderProperties) {
        this.contentCalenderProperties = contentCalenderProperties;
    }

    @GetMapping("/")
    public ContentCalenderProperties home(){
        return contentCalenderProperties;
    }
}
