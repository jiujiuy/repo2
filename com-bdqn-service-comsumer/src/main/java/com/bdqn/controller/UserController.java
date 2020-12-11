package com.bdqn.controller;


import com.bdqn.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getuser.do")
    @ResponseBody
    public User getUserById(int id) {

        String baseUrl = "http://service-provider/selectone.do/"+id;
        User user = this.restTemplate.getForObject(baseUrl, User.class);
        return user;

    }

}
