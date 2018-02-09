package com.feign.demo.Controller;


import com.feign.demo.service.Client2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *   
 *  Created with IDEA  
 *  @author:尚旭波  
 *  @Date:2018/2/6  
 *  @Time:11:20    
 *  
 */
@RestController
@RequestMapping("/client2")
public class Client2Controller {

    @Value("${server.port}")
    private String port;

    @Autowired
    private Client2Service client2Service;




    @RequestMapping("/sayHello")
    public String sayHello(@RequestParam String  name) {
        client2Service.sayHello(name);



        return "Hello :" + name +": i am form "+ port;
    }



}
