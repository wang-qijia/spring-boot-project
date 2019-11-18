package com.sunhome.boot.actuator.aspect;

import com.sunhome.boot.actuator.annotation.RequestRate;
import io.micrometer.core.instrument.Timer;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;

/**
 * @author wangqijia
 * @date 2019/11/13 11:44
 */
//切面类
@Aspect
@Component
public class HttpMethodCostAspect {

    @Autowired
    PrometheusMeterRegistry meterRegistry;

    private static final String HTTP_PRE = "http";

    /**
     * 拦截controller路径下方法标注@RequestRate注解
     */
    @Pointcut("@annotation(com.sunhome.boot.actuator.annotation.RequestRate) && execution(* com.sunhome.boot.actuator.controller..*.*(..))")
    public void pointcut() {
    }

    @Around(value = "pointcut() ")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
        Method targetMethod = ((MethodSignature) joinPoint.getSignature()).getMethod();
        //这里是为了拿到实现类的注解
        Method currentMethod = ClassUtils.getUserClass(joinPoint.getTarget().getClass())
                .getDeclaredMethod(targetMethod.getName(), targetMethod.getParameterTypes());

        if (currentMethod.isAnnotationPresent(RequestRate.class)) {
            RequestRate methodMetric = currentMethod.getAnnotation(RequestRate.class);
            return processMetric(joinPoint, currentMethod, methodMetric);
        } else {
            return joinPoint.proceed();
        }
    }

    private Object processMetric(ProceedingJoinPoint joinPoint, Method currentMethod,
                                RequestRate methodMetric) {
        Timer timer = Timer.builder("http_requests_rate").tags(methodMetric.tags())
                .description("http 请求接口")
                .register(meterRegistry);
        System.out.println("add timer");
        return timer.record(() -> {
            try {
                return joinPoint.proceed();
            } catch (Throwable throwable) {
                throw new IllegalStateException(throwable);
            }
        });
    }

}