package com.wjf.dynamic.util;

import com.google.gson.Gson;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * @Auther: cookie
 * @Date: 2018/7/27 10:17
 * @Description: 使用AOP统一处理Web请求日志
 */
@Aspect
@Component
public class WebControllerAop {
    private Logger log = (Logger) Logger.getLogger(String.valueOf(getClass()));
    private Gson gson = new Gson();
    ThreadLocal<Long>  startTime = new ThreadLocal<Long>();
    /**
     * 指定切点
     * 匹配 com.example.demo.controller包及其子包下的所有类的所有方法
     */
    @Pointcut("execution(public * com.wjf.dynamic.controller.*.*(..))")
    public void webLog(){
    }

    /**
     * 前置通知，方法调用前被调用
     * @param joinPoint
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){
        //前置通知
        //设置开始时间
        startTime.set(System.currentTimeMillis());
        Signature signature = joinPoint.getSignature();
        //AOP代理类的类（class）信息
        signature.getDeclaringType();
        MethodSignature methodSignature = (MethodSignature) signature;
        String[] strings = methodSignature.getParameterNames();
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //打印请求内容
        log.info("===============请求内容===============");
        log.info("请求URL:" + request.getRequestURL().toString());
        log.info("请求方式:" + request.getMethod());
        log.info("请求类方法:" + joinPoint.getSignature());
        log.info("请求类方法参数名"+Arrays.toString(strings));
        log.info("请求类方法参数:" + Arrays.toString(joinPoint.getArgs()));
        log.info("请求IP:" + request.getRemoteAddr());
        log.info("===============请求内容===============");
    }

    /**
     * 处理完请求返回内容
     * @param ret
     * @throws Throwable
     */
    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        log.info("--------------返回内容----------------");
        log.info("Response内容:" + gson.toJson(ret));
        log.info("--------------返回内容----------------");
        log.info("请求处理时间为:"+(System.currentTimeMillis() - startTime.get()));
    }

    /**
     * 后置异常通知
     * @param jp
     */
    @AfterThrowing("webLog()")
    public void throwss(JoinPoint jp){
        log.info("方法异常时执行....."+jp);
    }

    /**
     * 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
     * @param jp
     */
    @After("webLog()")
    public void after(JoinPoint jp){

    }

    /**
     * 环绕通知,环绕增强，相当于MethodInterceptor
     * @param pjp
     * @return
     */
    @Around("webLog()")
    public Object arround(ProceedingJoinPoint pjp) {
        try {
            Object o =  pjp.proceed();
            return o;
        } catch (Throwable e) {
            log.info("--------------异常消息----------------");
            log.info(e.getMessage());
            log.info("--------------异常消息----------------");
            e.printStackTrace();
            return null;
        }
    }

}