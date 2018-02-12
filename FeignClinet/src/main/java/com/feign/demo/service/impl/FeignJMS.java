package com.feign.demo.service.impl;

import ch.qos.logback.classic.net.JMSQueueAppender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 *   
 *  Created with IDEA  
 *  @author:尚旭波  
 *  @Date:2018/2/11  
 *  @Time:15:01    
 *  
 */
@Service("producer")
public class FeignJMS {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;



    public void sendMsg(Destination destination, String message){
        jmsMessagingTemplate.convertAndSend(destination,message);
    }


}
