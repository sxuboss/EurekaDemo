package com.feign.demo.controller;


import com.feign.demo.service.impl.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *   
 *  Created with IDEA  
 *  @author:尚旭波  
 *  @Date:2018/2/6  
 *  @Time:13:52    
 *  
 */
@RestController
public class FeignController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private FeignService feignService;


   @RequestMapping(value = "/sayHello" ,method = RequestMethod.GET)
    public String sayHello(@RequestParam String name) {
       System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
       String s = feignService.sayHello(name);
       System.out.println(s);
       return "Hello "+name+ "i am from "+ port ;
    }




}
