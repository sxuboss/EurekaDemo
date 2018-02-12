package com.feign.demo.controller;


import ch.qos.logback.classic.net.JMSQueueAppender;
import com.feign.demo.service.impl.FeignJMS;
import com.feign.demo.service.impl.FeignService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

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

    @Autowired
    private FeignJMS feignJMS;

    @Autowired
    private Queue queue;


   @RequestMapping(value = "/sayHello" ,method = RequestMethod.GET)
    public String sayHello(@RequestParam String name) {
       System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
       String s = feignService.sayHello(name);
       System.out.println(s);
       feignJMS.sendMsg(queue,"hhhhhhhhhhhhhhhhhhhhhhhhh");
       return "Hello "+name+ "i am from "+ port ;
    }




}
