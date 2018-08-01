package com.hh.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
*author huangh
*date 2018/7/27 9:17
*description activeMq消息生产者
*/


@RestController
public class QueueController {
  @Autowired
  private JmsMessagingTemplate jmsMessagingTemplate;

  @RequestMapping("/send")

  public void sendMessage(){
      Map<String, String> map = new HashMap<>();
      map.put("phoneNumber","15216162045");
      map.put("signName","黄浩");
      map.put("templateCode","SMS_140640081");
      map.put("templateParam","{\"name\":\"kevin\",\"code\":\"123\"}");

    jmsMessagingTemplate.convertAndSend("signInSms",map);
  }

}
