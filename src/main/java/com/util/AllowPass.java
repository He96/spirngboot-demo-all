package com.util;

import java.lang.annotation.*;

/**
 * 自定义权限是否需要登录
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AllowPass {
}
