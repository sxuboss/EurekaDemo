package com.feign.demo.service.impl;

import com.feign.demo.service.Client2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *   
 *  Created with IDEA  
 *  @author:尚旭波  
 *  @Date:2018/2/6  
 *  @Time:11:21    
 *  
 */
@Service
public class Client2ServiceImpl implements Client2Service {

    @Autowired
    private RestTemplate restTemplate;

    @Value("server:.port")
    private String prot;


    @Override
    public void sayHello(String name ) {
               String forObject = restTemplate.getForObject("http://SERVICEHI/hi?name="+name, String.class);
        System.out.println("forObject"+forObject);

    }

    @JmsListener(destination = "FeignQueue")
    public void reviceMsg(String text){
        System.out.println("I am ffom  "+ prot+ " : 接受到消息为： "+text);
    }
}
