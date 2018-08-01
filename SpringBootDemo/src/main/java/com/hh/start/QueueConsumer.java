package com.hh.start;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
*author huangh
*date 2018/7/27 9:29
*description 队列消费者
*/
@Component
public class QueueConsumer {
  @JmsListener(destination = "huangh")
  public void getMessage(String text){
    System.out.println("接收到的消息"+text);
  }

}
