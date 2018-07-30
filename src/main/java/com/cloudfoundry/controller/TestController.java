package com.cloudfoundry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping(value = "/cloudfoundry")
    @ResponseBody
    public String cloudFoundry() {
        return "Hello cloudFoundry...";
    }

}
