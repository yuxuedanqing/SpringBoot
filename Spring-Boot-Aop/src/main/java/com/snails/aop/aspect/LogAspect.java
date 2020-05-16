package com.snails.aop.aspect;

import com.snails.aop.annotation.Log;
import com.snails.aop.dao.SysLogDao;
import com.snails.aop.domain.SysLog;
import com.snails.aop.util.HttpContextUtils;
import com.snails.aop.util.IpUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

@Aspect
@Component
public class LogAspect {

    @Autowired
    private SysLogDao sysLogDao;

    @Pointcut("@annotation(com.snails.aop.annotation.Log)")
    public void pointcut(){};

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point){
        Object result = null;
        long beginTime = System.currentTimeMillis();
        try {
            // 执行方法
            result = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        // 执行时长（毫秒）
        long time = System.currentTimeMillis()-beginTime;
        // 保存日志
        saveLog(point,time);
        return result;
    }

    private void saveLog(ProceedingJoinPoint point,long time){
        MethodSignature signature = (MethodSignature)point.getSignature();
        Method method = signature.getMethod();
        SysLog sysLog = new SysLog();
        Log logAnnotation = method.getAnnotation(Log.class);
        if(logAnnotation!=null){
            // 注解上的描述
            sysLog.setOperation(logAnnotation.value());
        }
        // 请求的方法名
        String className = point.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className+"."+methodName+"()");
        // 请求的方法参数
        Object[] args = point.getArgs();
        // 请求的方法参数名称
        LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();
        String[] parameterNames = discoverer.getParameterNames(method);
        if(args!=null && parameterNames!=null){
            StringBuilder params = new StringBuilder();
            for (int i = 0; i < args.length; i++) {
                params.append(" ").append(parameterNames[i]).append(":").append(args[i]);
            }
            sysLog.setParams(params.toString());
        }
        // 获取request
        HttpServletRequest request = HttpContextUtils.getServletRequest();
        sysLog.setIp(IpUtils.getIpAddress(request));
        // 模拟一个用户
        sysLog.setUserName("snails");
        sysLog.setTime((int) time);
        sysLog.setCreateTime(LocalDateTime.now());
        // 保存系统日志
        sysLogDao.saveSysLog(sysLog);
    }
}
