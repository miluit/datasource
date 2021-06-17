package com.taotao.demo.config.datasource.multiple;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class DataSourceAspect {

    @Pointcut("@annotation(com.taotao.demo.config.datasource.multiple.DataSource)")
    public void dsPointCut() {

    }

    @Around("dsPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable{
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        //如果是代理类取不到注解，试试这个方法吧
        //method = point.getTarget().getClass().getMethod(point.getSignature().getName(), ((MethodSignature)point.getSignature()).getMethod().getParameterTypes());
        DataSource dataSource = method.getAnnotation(DataSource.class);
        if (dataSource != null) {
            DynamicDataSourceContextHolder.setDataSourceName(dataSource.value());
        } else {

        }
        try {
            return point.proceed();
        } finally {
            // 销毁数据源 在执行方法之后
            DynamicDataSourceContextHolder.clearDataSourceName();
        }
    }

}
