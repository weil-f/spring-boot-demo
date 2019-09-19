package com.rabbitmq.demo.controller;

import com.rabbitmq.demo.annotation.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Package: com.rabbitmq.demo.controller
 * Date: Created in 2019/8/29 11:35
 *
 * @Version: 1.0.0
 * @author:weil-f
 */
@RestController
@RequestMapping("hello")
public class IndexController {





  @LogService(methodName = "你好",className = "测试控制器")
  @RequestMapping(value = "hello")
  public Map<String,String> hello(String hello,Integer age){
    HashMap<String, String> map = new HashMap<>();
    map.put("ok","succ");
    map.put("msg","hello");
    return map;
  }
}
