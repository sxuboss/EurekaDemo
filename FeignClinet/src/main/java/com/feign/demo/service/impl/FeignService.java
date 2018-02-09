package com.feign.demo.service.impl;

import javafx.application.Application;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sun.awt.SunHints;

/**
 *   
 *  Created with IDEA  
 *  @author:尚旭波  
 *  @Date:2018/2/6  
 *  @Time:13:52    
 *  
 */

@FeignClient("SERVICEHI")
public interface FeignService {


    @LoadBalanced
    @RequestMapping(value="/hi" ,method = RequestMethod.POST)
    String sayHello(@RequestParam("name") String name );



}
