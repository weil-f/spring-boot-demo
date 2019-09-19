package com.rabbitmq.demo.aspect;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.demo.annotation.LogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;


@Aspect
@Component
@Slf4j
public class LogAspect {

  @Autowired
  private HttpServletRequest request;

  @Pointcut("@annotation(com.rabbitmq.demo.annotation.LogService)")
  public void pointCart(){ }
  @Before("pointCart()")
  public void pre(JoinPoint joinPoint){
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    LogService annotation = signature.getMethod().getAnnotation(LogService.class);
    String className = joinPoint.getTarget().getClass().getName();
    String kind = joinPoint.getKind();
    JoinPoint.StaticPart staticPart = joinPoint.getStaticPart();

    Object[] args = joinPoint.getArgs();
    List<Object> objects = Arrays.asList(args);
    log.info("【AOP前置通知】获取到类的名字为===>{}的方法名字为===>{},方法传递的参数为===>{},kind===>{}",className,annotation.methodName(), JSON
      .toJSONString(objects),kind);
  }

  @AfterReturning(pointcut = "pointCart()",returning="result")
  public void after(JoinPoint joinPoint ,Object result){
    log.info("【AOP后置通知】:方法的返回值为===>{}",JSON.toJSONString(result));
  }
}
