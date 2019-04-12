package com.zsx.web.config;

import com.zsx.web.util.CacheUtil;

import java.lang.annotation.*;

/**
 * Created by ZSX on 2018/1/24.
 *
 * @author ZSX
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface MyAnno {

    CacheUtil.CacheEnum value();

}

