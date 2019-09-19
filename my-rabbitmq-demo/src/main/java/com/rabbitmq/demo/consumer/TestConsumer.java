package com.rabbitmq.demo.consumer;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Package: com.rabbitmq.demo.consumer
 * Date: Created in 2019/8/28 17:42
 *
 * @Version: 1.0.0
 * @author:weil-f
 */
//@Component
public class TestConsumer {
  @RabbitListener(bindings = {
    @QueueBinding(value =@Queue(value = "msg"),exchange = @Exchange(value = "spring.test"),key = "a.b")
  })
  public void getMsg(String msg){
    System.out.println("【消费者】收到的消息为===>"+msg);

  }
}
