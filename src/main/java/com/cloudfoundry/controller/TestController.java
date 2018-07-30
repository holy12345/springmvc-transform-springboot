package com.cloudfoundry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping(value = "/cloudfoundry")
    public String cloudFoundry() {
        return "index";
    }

}
