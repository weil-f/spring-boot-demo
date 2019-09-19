package com.rabbitmq.demo.annotation;

import java.lang.annotation.*;

/**
 * Package: com.rabbitmq.demo.annotation
 * Date: Created in 2019/8/29 13:23
 * 记录日志的自定义注解
 * @Version: 1.0.0
 * @author:weil-f
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public@interface LogService {

  /**
   * 方法名字
   * @return
   */
  String methodName() default "";

  String className() default "";


}
