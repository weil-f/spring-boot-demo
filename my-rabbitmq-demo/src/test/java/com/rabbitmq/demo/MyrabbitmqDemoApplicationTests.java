package com.rabbitmq.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.InputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyrabbitmqDemoApplicationTests {

  @Autowired
  private AmqpTemplate amqpTemplate;

	@Test
	public void contextLoads() {
	  try {
	    for (int i = 1;i<=50;i++){
        amqpTemplate.convertAndSend("spring.test","a.b",i);
      }
    }catch (Exception e){
	    e.printStackTrace();
    }
    System.out.println("【生产者】数据发送完毕了!!!");
  }

}
