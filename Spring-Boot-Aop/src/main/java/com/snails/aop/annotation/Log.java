package com.snails.aop.annotation;

import java.lang.annotation.*;

/**
 * 自定义日志记录注解
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {

    String value() default "";
}
